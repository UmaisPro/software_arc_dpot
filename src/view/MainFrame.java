package view;

import javax.swing.*;
import controller.Worker;
import model.QueueofCustomers;
import model.ParcelMap;
import model.Customer;
import model.Parcel;
import java.awt.*;

public class MainFrame extends JFrame {
    private QueueofCustomers queue;
    private ParcelMap parcels;
    private JTextArea customerListArea;
    private JTextArea parcelListArea;
    private JTextArea feeListArea;
    private Worker worker;

    public MainFrame(QueueofCustomers queue, ParcelMap parcels, Worker worker) {
        this.queue = queue;
        this.parcels = parcels;
        this.worker = worker;

        setTitle("Depot Worker System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        customerListArea = new JTextArea(10, 30);
        customerListArea.setEditable(false);
        parcelListArea = new JTextArea(10, 30);
        parcelListArea.setEditable(false);
        feeListArea = new JTextArea(10, 30);
        feeListArea.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JScrollPane(customerListArea));
        panel.add(new JScrollPane(parcelListArea));
        panel.add(new JScrollPane(feeListArea));

        add(panel, BorderLayout.CENTER);

        loadData();
    }

    public void loadData() {
        customerListArea.setText("");
        for (Customer customer : queue.getQueue()) {
            customerListArea.append(customer.getName() + "\n");
        }

        parcelListArea.setText("");
        for (Parcel parcel : parcels.getAllParcels().values()) {
            parcelListArea.append(parcel.getId() + ": " + parcel.getDestination() + "\n");
        }

        feeListArea.setText("");
        for (Customer customer : queue.getQueue()) {
            double fee = worker.calculateFee(customer);
            feeListArea.append(customer.getName() + " Fee: $" + fee + "\n");
        }
    }
}
