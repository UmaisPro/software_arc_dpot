package view;

import javax.swing.*;
import controller.Worker;
import model.Customer;
import model.Parcel;
import model.ParcelMap;
import model.QueueofCustomers;

public class Manager {
    public static void main(String[] args) {
       
        QueueofCustomers queue = new QueueofCustomers();
        ParcelMap parcels = new ParcelMap();
        Worker worker = new Worker(queue, parcels);

        
        generateInitialData(queue, parcels);

        
        addManualData(queue, parcels);

        
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(queue, parcels, worker);
            frame.setVisible(true);
        });

        
        worker.processNextCustomer();
    }

    
    private static void generateInitialData(QueueofCustomers queue, ParcelMap parcels) {
        for (int i = 1; i <= 10; i++) {
            Parcel parcel = new Parcel("P" + i, Math.random() * 5 + 1, "Destination " + i);
            parcels.addParcel(parcel);
        }

        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer("C" + i, "Customer " + i);
            for (int j = 1; j <= 3; j++) {
                customer.addParcel("P" + ((i - 1) * 3 + j));
            }
            queue.enqueue(customer);
        }
    }

   
    private static void addManualData(QueueofCustomers queue, ParcelMap parcels) {
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Manual Data Entry",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Add Customer", "Add Parcel", "Processing List"},
                    "Add Customer"
            );

            if (choice == 0) { 
                String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
                String customerName = JOptionPane.showInputDialog("Enter Customer Name:");
                if (customerId != null && customerName != null) {
                    Customer customer = new Customer(customerId, customerName);
                    String parcelIds = JOptionPane.showInputDialog("Enter Parcel IDs (comma-separated):");
                    if (parcelIds != null) {
                        for (String parcelId : parcelIds.split(",")) {
                            customer.addParcel(parcelId.trim());
                        }
                    }
                    queue.enqueue(customer);
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");
                }
            } else if (choice == 1) {
                String parcelId = JOptionPane.showInputDialog("Enter Parcel ID:");
                String destination = JOptionPane.showInputDialog("Enter Destination:");
                String weightInput = JOptionPane.showInputDialog("Enter Weight (in kg):");
                if (parcelId != null && destination != null && weightInput != null) {
                    try {
                        double weight = Double.parseDouble(weightInput);
                        if (weight <= 0) {
                            JOptionPane.showMessageDialog(null, "Weight must be a positive number.");
                            continue;
                        }
                        Parcel parcel = new Parcel(parcelId, weight, destination);
                        parcels.addParcel(parcel);
                        JOptionPane.showMessageDialog(null, "Parcel added successfully!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid weight entered. Please try again.");
                    }
                }
            } else { 
                break;
            }
        }
    }
}
