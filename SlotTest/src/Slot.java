import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;

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
	private Text textpay;
	private Text txtSoldiVeri;
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
		punti.setForeground(SWTResourceManager.getColor(255, 255, 255));
		punti.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		punti.setBounds(201, 521, 185, 37);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Slot.class, "/img/arancia.png"));
		//lblNewLabel.setSize(50,50);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/ciliegia.png"));

		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Slot.class, "/img/prugna.png"));
		
		punti.setText("BET: "+ rimasti);				
		
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.setImage(SWTResourceManager.getImage(Slot.class, "/img/startgiusto.jpg"));
		btnStart.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Slot s=new Slot();
				display = Display.getDefault();
				
				Genera();
				
				rimasti = rimasti - 1;			
				
			    punti.setText("BET: "+ rimasti); 

			    
				
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
		btnStart.setBounds(10, 288, 87, 85);

		lblNewLabel_2.setBounds(139, 140, 123, 117);
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
				punti.setText("BET: "+ rimasti);
				}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(Slot.class, "/img/resetgiusto.jpg"));
		btnNewButton.setBounds(289, 288, 75, 75);
		
		Label lblClassificaTitle = new Label(shell, SWT.NONE);
		lblClassificaTitle.setFont(SWTResourceManager.getFont("Showcard Gothic", 14, SWT.BOLD));
		lblClassificaTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblClassificaTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblClassificaTitle.setBounds(10, 367, 123, 25);
		lblClassificaTitle.setText("CLASSIFICA:");
		
		Classifica = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP |SWT.V_SCROLL);
		Classifica.setFont(SWTResourceManager.getFont("Showcard Gothic", 12, SWT.BOLD));
		Classifica.setForeground(SWTResourceManager.getColor(255, 255, 255));
		Classifica.setBackground(SWTResourceManager.getColor(0, 0, 0));
		Classifica.setBounds(10, 398, 381, 117);
		
		puntiTest = new Text(shell, SWT.BORDER);
		puntiTest.setFont(SWTResourceManager.getFont("Showcard Gothic", 12, SWT.BOLD));
		puntiTest.setForeground(SWTResourceManager.getColor(255, 255, 255));
		puntiTest.setBackground(SWTResourceManager.getColor(255, 0, 0));
		puntiTest.setBounds(10, 521, 185, 37);
		puntiTest.setText("PUNTI: ");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(0, 134, 4, 133);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 130, 401, 4);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 263, 401, 4);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_3.setBounds(397, 131, 4, 133);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textpay.append("0 figure uguali: 0 "  + "\n" +" 2 figure uguali: 50" + "\n"+ "3 figure uguali: 100" + "\n");  
			
				
			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/pay table.jpg"));
		btnNewButton_1.setFont(SWTResourceManager.getFont("Showcard Gothic", 13, SWT.NORMAL));
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnNewButton_1.setBounds(139, 287, 87, 80);
		
		textpay = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP |SWT.V_SCROLL);
		textpay.setFont(SWTResourceManager.getFont("Showcard Gothic", 12, SWT.NORMAL));
		textpay.setForeground(SWTResourceManager.getColor(255, 255, 255));
		textpay.setBackground(SWTResourceManager.getColor(255, 0, 0));
		textpay.setBounds(10, 564, 376, 105);
		
		txtSoldiVeri = new Text(shell, SWT.NONE);
		txtSoldiVeri.setForeground(SWTResourceManager.getColor(255, 255, 0));
		txtSoldiVeri.setFont(SWTResourceManager.getFont("Segoe Script", 14, SWT.BOLD));
		txtSoldiVeri.setBackground(SWTResourceManager.getColor(0, 0, 0));
		txtSoldiVeri.setText("Soldi veri!!!!");
		txtSoldiVeri.setBounds(128, 687, 148, 41);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel_4.setImage(SWTResourceManager.getImage(Slot.class, "/img/soldi.png"));
		lblNewLabel_4.setBounds(10, 675, 112, 53);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBackground(SWTResourceManager.getColor(0, 0, 0));
		label_4.setImage(SWTResourceManager.getImage(Slot.class, "/img/soldi.png"));
		label_4.setBounds(274, 675, 112, 53);
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