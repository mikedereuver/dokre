package assignment2.gui;

import assignment2.Facade;
import assignment2.vehicle.*;
import java.util.*;
import javax.swing.JTextArea;

public class TextOutput extends JTextArea implements Observer
{

	/** Creates new form TextOutput */
	public TextOutput()
	{
		initComponents();
		
		printTrainYard();
	}

	public void update(Observable o, Object arg)
	{
		printTrainYard();
	}

	private void printTrainYard()
	{
		Facade f = new Facade();
		HashMap<String, Vehicle> vehicles = f.getVehicles();

		setText("wagons\n\r");
 		for (String key : vehicles.keySet())
		{
			try
			{
				Wagon w = (Wagon)vehicles.get(key);
				setText(getText() + "("+w.getId()+":"+w.getNumberOfSeats()+") ");
			}
			catch(Exception e){}
		}

		setText(getText() + "\n\rtrains\n\r");
 		for (String key : vehicles.keySet())
		{
			try
			{
				Train t = (Train)vehicles.get(key);
				setText(getText() + "("+t.getId()+") ");
				
				ArrayList<Wagon> wagons = t.getWagons();
				for (int i = 0; i < wagons.size(); i++)
				{
					Wagon w = wagons.get(i);
					setText(getText() + "-("+w.getId()+") ");
				}
				setText(getText() + "\n\r");
			}
			catch(Exception e){}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
