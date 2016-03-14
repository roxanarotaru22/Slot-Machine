import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;

public class Slot<g> {
	Display display = Display.getDefault();
	protected Shell shell;
	private Text punti;
	private ArrayList<Image> img = new ArrayList<Image>();

	Label lblNewLabel;
	Label lblNewLabel_1;
	Label lblNewLabel_2;
	int r;
	int r1;
	int r2;
	int t;
	int t1;
	int points = 0;						//Variabile he tiene conto dei punti accumulati
	int retry = 10;						//Indica il numero di riprova posseduti all'inizio di una partita
	int retryremaining;					//variabile contenete i riprova rimanenti
	int plays = 1;
	private Text Classifica;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Slot window = new Slot();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents(display);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @param s
	 */
	protected void createContents(Object s) {
		
		retryremaining = retry;					//imposto i retry disponibili quando il programma si avvia
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		shell.setSize(417, 766);
		shell.setText("SWT Application");
		img.add(new Image(display, "arancia.png"));
		img.add(new Image(display, "ciliegia.png"));
		img.add(new Image(display, "prugna.png"));

		punti = new Text(shell, SWT.BORDER);
		punti.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		punti.setBounds(103, 401, 185, 37);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Slot.class, "/img/arancia.png"));
		//lblNewLabel.setSize(50,50);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/ciliegia.png"));

		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Slot.class, "/img/prugna.png"));
		
		punti.setText("Riprova: "+ retryremaining);				//imposto il testo nella label all'inizio del gioco

		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.setImage(SWTResourceManager.getImage(Slot.class, "/img/start-here.png"));
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Slot s=new Slot();
				display = Display.getDefault();
				Genera();
				retryremaining = retryremaining - 1;			//una volta premuto il pulsante, tolgo un riprova 
				
			    punti.setText("Riprova: "+ retryremaining); //se i riprova non sono terminati, scrivo quanti ne rimagono nella label
				
				
				
				/*
				 * if(lblNewLabel.equals(lblNewLabel_1) || ) if(img.equals(img1)
				 * || img.equals(img2)|| img1.equals(img2) ){
				 * System.out.println("ciao"); punti.setText("100"); }
				 */

				Timer timer = new Timer();
				
				

				// Schedule to run after every 3 second(3000 millisecond)
				timer.scheduleAtFixedRate(new Task(), 30, 30);
				
				

			}
		});
		btnStart.setBounds(10, 358, 87, 85);

		lblNewLabel_2.setBounds(141, 140, 115, 117);
		lblNewLabel.setBounds(10, 140, 123, 117);
		lblNewLabel_1.setBounds(268, 140, 123, 117);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setImage(SWTResourceManager.getImage(Slot.class, "/img/slot1.png"));
		lblNewLabel_3.setBounds(0, 0, 547, 117);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {					//PULSANTE RESET
				points = 0;													//azzero i punti
				retryremaining = retry;										//reimposto i riprova
				punti.setText("Riprova: "+ retryremaining);					//aggiorno la label di testo con i riprova 
				}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(Slot.class, "/img/reset.png"));
		btnNewButton.setBounds(294, 363, 75, 75);
		
		Label lblClassificaTitle = new Label(shell, SWT.NONE);
		lblClassificaTitle.setBounds(10, 449, 123, 25);
		lblClassificaTitle.setText("CLASSIFICA:");
		
		Classifica = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP |SWT.V_SCROLL);
		Classifica.setBounds(10, 480, 381, 191);
	}

	class Task extends TimerTask {

		int count = 1;

		public void run() {

			// richiama il metodo per la grafica sul thread principale
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					
					// TODO Auto-generated method stub
					Genera();
				}

			});
			
			// Codice dello sleep
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			
			count++;
			if (count == 8) {
				this.cancel();
				if (r == r1 || r == r2 || r1 == r2) {				//se ci sono 2 immagini uguali sommo 50 ai punti
					 points = points + 50;
					System.out.println(points);

					if (r == r1 && r == r2 && r1 == r2) {			//inoltre se le 3 immagini sono identiche sommo altri 50 punti in modo che 50+50 = 100 punti
						points = points + 50;
						System.out.println(points);
						
					}
				}
				
				//METODO CHE PERMETTE DI AGGIORNARE LE INFORMAZIONE NELLA LABEL IN UN TIMER -> RICAVATO DA INTERNET: https://wiki.eclipse.org/FAQ_Why_do_I_get_an_invalid_thread_access_exception%3F
				Display.getDefault().asyncExec(new Runnable() {
		               public void run() {
		            	   
		            	   if (retryremaining <= 0){				    //se i riprova sono terminati, faccio vedere i punti fatti nella labe�
		   					punti.setText("PUNTI: " + points);
		   					retryremaining = retry;						//reimposto i riprova per una nuova sessione di gioco
		   					Classifica.append("Giocata n�: " + plays + " - Punti: " + points + "\n");   //compilo la classifica una volta termitati i tentativi, appendendo il nuovo risultato al testo gia presente nella text-box
		   					plays = plays + 1;							//aggiungo 1 alle giocate
		   					points = 0;									//riazzero i punti
		   				}
		   				
		               }
		            });
			
			}
			
			
			
		}

	}

	public void Genera() {

		Label[] l = new Label[] { lblNewLabel, lblNewLabel_1, lblNewLabel_2 };

		Random ran = new Random();
		r = ran.nextInt(3);
		l[0].setImage(img.get(r));
		r1 = ran.nextInt(3);
		l[1].setImage(img.get(r1));
		r2 = ran.nextInt(3);
		l[2].setImage(img.get(r2));

	}
}
