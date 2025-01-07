package view;

import javax.swing.SwingUtilities;
import controller.Worker;
import model.Customer;
import model.Parcel;
import model.ParcelMap;
import model.QueueofCustomers;

public class Manager {
    public static void main(String[] args) {
        // Initialize objects
        QueueofCustomers queue = new QueueofCustomers();
        ParcelMap parcels = new ParcelMap();
        Worker worker = new Worker(queue, parcels);

        // Add parcels to ParcelMap
        for (int i = 1; i <= 10; i++) {
            Parcel parcel = new Parcel("P" + i, Math.random() * 5 + 1, "Destination " + i);
            parcels.addParcel(parcel);  
        }

        
        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer("C" + i, "Customer " + i);
            for (int j = 1; j <= 5; j++) {
                customer.addParcel("P" + j);  
            }
            queue.enqueue(customer);  
        }

        
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(queue, parcels, worker); 
            frame.setVisible(true);
        });

        
        worker.processNextCustomer();  
    }
}
