package personal.records.ui;

import org.springframework.stereotype.Component;
import personal.records.entity.Country;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
public class PersonInfo extends JPanel{
    private JComboBox countryField;
    private JTextField postalCodeField;
    private JTextField givenNameField;
    private JTextField surnameField;
    private JTextField address1Field;
    private JTextField address2Field;
    private JTextField townField;
    private JTextField countyField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JButton button1;
    private JSpinner spinner1;
    private final CountryComboBoxModel countryComboBoxModel;

    public PersonInfo(CountryComboBoxModel countryComboBoxModel) {
        this.countryComboBoxModel = countryComboBoxModel;
    }


    @PostConstruct
    private void preparePanel() {
        countryField = new JComboBox<>(countryComboBoxModel);
//        setPanelUp();
//        initComponents();
    }
}
