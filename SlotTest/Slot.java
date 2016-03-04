import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

public class Slot<g> {
	Display display = Display.getDefault();
	protected Shell shell;
	private Text punti;
	private ArrayList<Image> img = new ArrayList<Image>();

	
	/**
	 * Launch the application.
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
	 * @param s 
	 */
	protected void createContents(Object s) {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		img.add(new Image(display,"arancia.png"));
		img.add(new Image(display,"ciliegia.png"));
		img.add(new Image(display,"prugna.png"));
		
		punti = new Text(shell, SWT.BORDER);
		punti.setBounds(10, 202, 104, 21); 
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Slot.class, "/img/arancia.png"));
		//lblNewLabel.setSize(50,50);
		
		
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/ciliegia.png"));
		
		
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Slot.class, "/img/prugna.png"));
		
		
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Slot s=new Slot();
				display = Display.getDefault();
				Genera(display, new Label[]{lblNewLabel, lblNewLabel_1, lblNewLabel_2}, img);
				/*if(lblNewLabel.equals(lblNewLabel_1) || )
				if(img.equals(img1) || img.equals(img2)|| img1.equals(img2) ){
					System.out.println("ciao");
					punti.setText("100");
				}
				*/
				
			
					  
				   }
		});
		btnStart.setBounds(10, 171, 75, 25);
		btnStart.setText("START");
		
		lblNewLabel_2.setBounds(131, 0, 115, 117);
		lblNewLabel.setBounds(10, 0, 115, 117);
		lblNewLabel_1.setBounds(252, 0, 115, 117);
	}

	/*public void Confronta(){
		if(img.equals(img) && img.equals(img)&& img.equals(img) ){
			System.out.println("ciao");
			punti.setText("100");
		}
	}*/
	public void Genera(Display display, Label [] l, ArrayList<Image> img) {
		  /* var img = new Array("arancia.png","ciliegia.png","prugna.png");
		   var x = Math.floor(img.lenght*Math.random(3));*/
		   //document.write('<img src =\"'+img[x]+'\"alt=\"Non disponibile\">')
		   int r;
		   int r1;
		   int r2;
		   int p=0;
			 int p1=0;
		   Random ran = new Random();
		   r = ran.nextInt(3);
		   l[0].setImage(img.get(r));
		   r1 = ran.nextInt(3);
		   l[1].setImage(img.get(r1));
		   r2 = ran.nextInt(3);
		   l[2].setImage(img.get(r2));
		 
		   if(r == r1 || r == r2 || r1 == r2)
		   {
				
				
			   p=50+p;
			   
			  
			  punti.setText(String.valueOf(p));
			 // System.out.println(p);
				  if(r1==r2 && r==r1 && r==r2){
						 
					
					  p1=100+p1;
					 // System.out.println(p);
					  
				  }
				  int p3;
				   p3=p+p1;
				   System.out.println("totale: "+p3);
		   }
		  
		   }
		   //document.write("<img src=\""+img[ran]+"\">");
	   thrt
	   }
	
	

