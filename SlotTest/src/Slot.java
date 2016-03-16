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
	int p = 0;						
	int tentativi = 10;						
	int rimasti;					
	int giocatore = 1;
	private Text Classifica;
	private Text puntiTest;
	int p1;
	int p2;
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
		
		rimasti = tentativi;					
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		shell.setSize(417, 766);
		shell.setText("SWT Application");
		img.add(new Image(display, "arancia.png"));
		img.add(new Image(display, "ciliegia.png"));
		img.add(new Image(display, "prugna.png"));

		punti = new Text(shell, SWT.BORDER);
		punti.setFont(SWTResourceManager.getFont("Showcard Gothic", 11, SWT.BOLD));
		punti.setForeground(SWTResourceManager.getColor(255, 0, 0));
		punti.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		punti.setBounds(103, 401, 185, 37);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Slot.class, "/img/arancia.png"));
		//lblNewLabel.setSize(50,50);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/ciliegia.png"));

		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Slot.class, "/img/prugna.png"));
		
		punti.setText("Riprova: "+ rimasti);				
		
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.setImage(SWTResourceManager.getImage(Slot.class, "/img/start.jpg"));
		btnStart.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Slot s=new Slot();
				display = Display.getDefault();
				
				Genera();
				
				rimasti = rimasti - 1;			
				
			    punti.setText("Tentativi: "+ rimasti); 

			    
				
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
			public void widgetSelected(SelectionEvent e) {					
				p = 0;													
				rimasti = tentativi;										
				punti.setText("Tentativi: "+ rimasti);
				}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(Slot.class, "/img/reset.png"));
		btnNewButton.setBounds(294, 363, 75, 75);
		
		Label lblClassificaTitle = new Label(shell, SWT.NONE);
		lblClassificaTitle.setFont(SWTResourceManager.getFont("Showcard Gothic", 14, SWT.BOLD));
		lblClassificaTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblClassificaTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblClassificaTitle.setBounds(10, 449, 123, 25);
		lblClassificaTitle.setText("CLASSIFICA:");
		
		Classifica = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP |SWT.V_SCROLL);
		Classifica.setFont(SWTResourceManager.getFont("Showcard Gothic", 12, SWT.BOLD));
		Classifica.setForeground(SWTResourceManager.getColor(255, 255, 255));
		Classifica.setBackground(SWTResourceManager.getColor(0, 0, 0));
		Classifica.setBounds(10, 480, 359, 192);
		
		puntiTest = new Text(shell, SWT.BORDER);
		puntiTest.setFont(SWTResourceManager.getFont("Showcard Gothic", 12, SWT.BOLD));
		puntiTest.setForeground(SWTResourceManager.getColor(0, 0, 0));
		puntiTest.setBackground(SWTResourceManager.getColor(255, 0, 0));
		puntiTest.setBounds(103, 358, 185, 37);
	}

	class Task extends TimerTask {

		int count = 1;

		public void run() {

			
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
				if (r == r1 || r == r2 || r1 == r2) {
					p = p + 50;
					System.out.println(p);
					
					if (r == r1 && r == r2 && r1 == r2) {	
						p = p + 50;
						System.out.println(p);
					}
					
				}
				
				Display.getDefault().asyncExec(new Runnable() {
		               public void run() {

		   				puntiTest.setText("Punti: " + p);
		            	   if (rimasti <= 0){				    
		   					punti.setText("PUNTI: " + p);
		   					rimasti = tentativi;						
		   					Classifica.append("Giocata numero: " + giocatore + " - Punti: " + p + "\n");  
		   					giocatore = giocatore + 1;							
		   					p = 0;									
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





/*File soundFile=new File (POSIZIONE BRANO MP3);
try{
posizione=new MediaLocator (soundFile. ToURL ()); 
lettore=Manager. CreatePlayer (posizione); 
}catch (Exception e){ e. PrintStackTrace (); }

lettore. Realize ();
lettore. Prefetch ();
lettore. Start ();*/