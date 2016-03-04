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
		shell = new Shell();
		shell.setSize(563, 506);
		shell.setText("SWT Application");
		img.add(new Image(display, "arancia.png"));
		img.add(new Image(display, "ciliegia.png"));
		img.add(new Image(display, "prugna.png"));

		punti = new Text(shell, SWT.BORDER);
		punti.setBounds(172, 417, 104, 21);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Slot.class, "/img/arancia.png"));
		// lblNewLabel.setSize(50,50);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Slot.class, "/img/ciliegia.png"));

		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Slot.class, "/img/prugna.png"));

		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.setImage(SWTResourceManager.getImage(Slot.class, "/img/start.jpg"));
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Slot s=new Slot();
				display = Display.getDefault();
				Genera();
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
		btnStart.setBounds(10, 363, 87, 75);

		lblNewLabel_2.setBounds(131, 140, 115, 117);
		lblNewLabel.setBounds(0, 140, 115, 117);
		lblNewLabel_1.setBounds(268, 140, 115, 117);
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
			int t1=0;
			// Codice dello sleep
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			count++;
			if (count == 10) {
				this.cancel();
				if (r == r1 || r == r2 || r1 == r2) {
					int f = 50;
					System.out.println(f);

					if (r == r1 && r == r2 && r1 == r2) {
						int i = 100;
						System.out.println(i);

						int t = 0;
						t = f + i;
						t1=t;
						System.out.println(t);
						
					}
				}
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
