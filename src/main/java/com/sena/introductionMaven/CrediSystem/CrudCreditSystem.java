package com.sena.introductionMaven.CrediSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class CrudCreditSystem {

    public VBox Formulario;
    public Label saldoPrestado;
    public Label saldoDeuda;
    @FXML private TextField txtTypePrestamo;
    @FXML private TextField txtIdDate;
    @FXML private TextField txtFirstName;
    @FXML private TextField txtIdNumber;
    @FXML private TextField txtLastName;
    @FXML private TextField txtSaldo;

    @FXML private TableView<Deudor> DeudorTable;
    @FXML private TableColumn<Deudor, String> colFirstName;
    @FXML private TableColumn<Deudor, String> colLastName;
    @FXML private TableColumn<Deudor, String> colIdNumber;
    @FXML private TableColumn<Deudor, String> colIdDate;
    @FXML private TableColumn<Deudor, Integer> colSaldo;

    @FXML private TableView<Deudor> PrestamoTable;
    @FXML private TableColumn<Deudor, String> colFirstNameP;
    @FXML private TableColumn<Deudor, String> colLastNameP;
    @FXML private TableColumn<Deudor, String> colIdNumberP;
    @FXML private TableColumn<Deudor, String> colIdDateP;
    @FXML private TableColumn<Deudor, Integer> colSaldoP;

    private Prestamo prestamo;

    @FXML
    private void initialize() {
        prestamo = new Prestamo("Prestamo de dinero");


        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colIdDate.setCellValueFactory(new PropertyValueFactory<>("idDate"));
        colIdNumber.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        DeudorTable.setOnMouseClicked(event -> {
            if (DeudorTable.getSelectionModel().getSelectedItem() != null) {
                loadInputFields(DeudorTable.getSelectionModel().getSelectedItem());
            }
        });


        colFirstNameP.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastNameP.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colIdDateP.setCellValueFactory(new PropertyValueFactory<>("idDate"));
        colIdNumberP.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        colSaldoP.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        PrestamoTable.setOnMouseClicked(event -> {
            if (PrestamoTable.getSelectionModel().getSelectedItem() != null) {
                loadInputFields(PrestamoTable.getSelectionModel().getSelectedItem());
            }
        });
    }

    @FXML
    public void createDeudors(ActionEvent actionEvent) {
        Deudor deudor = new Deudor(
                txtIdNumber.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                txtIdDate.getText(),
                txtSaldo.getText()
        );

        prestamo.addDeudor(deudor, txtTypePrestamo.getText());

        if ("preste".equalsIgnoreCase(txtTypePrestamo.getText())) {
            updateTable(DeudorTable, prestamo.getListaDeudas());
            sumaSaldoP();
        } else if ("debo".equalsIgnoreCase(txtTypePrestamo.getText())) {
            updateTable(PrestamoTable, prestamo.getListaPrestamos());
            SaldoDeuda();
        }
        clearInputFields();
    }

    @FXML
    private void updateDeudor() {
        if ("preste".equalsIgnoreCase(txtTypePrestamo.getText())) {
            Deudor selected = DeudorTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                fillDeudor(selected);
                prestamo.updateDeudor(selected);
                updateTable(DeudorTable, prestamo.getListaDeudas());
            }
        } else if ("debo".equalsIgnoreCase(txtTypePrestamo.getText())) {
            Deudor selected = PrestamoTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                fillDeudor(selected);
                prestamo.updateDeudor(selected);
                updateTable(PrestamoTable, prestamo.getListaPrestamos());
            }
        }
        clearInputFields();
    }

    @FXML
    private void deleteDeudor() {
        if ("preste".equalsIgnoreCase(txtTypePrestamo.getText())) {
            Deudor deudor = DeudorTable.getSelectionModel().getSelectedItem();
            if (deudor != null) {
                prestamo.deleteDeudor(deudor, "me deben");
                updateTable(DeudorTable, prestamo.getListaDeudas());
            }
        } else if ("debo".equalsIgnoreCase(txtTypePrestamo.getText())) {
            Deudor deudor = PrestamoTable.getSelectionModel().getSelectedItem();
            if (deudor != null) {
                prestamo.deleteDeudor(deudor, "debo");
                updateTable(PrestamoTable, prestamo.getListaPrestamos());
            }
        }
        clearInputFields();
    }

    public void verTabla(ActionEvent actionEvent) {
        DeudorTable.setVisible(true);
        PrestamoTable.setVisible(false);
        updateTable(DeudorTable, prestamo.getListaDeudas());
    }

    public void verTablaP(ActionEvent actionEvent) {
        DeudorTable.setVisible(false);
        PrestamoTable.setVisible(true);
        updateTable(PrestamoTable, prestamo.getListaPrestamos());
    }
    public void verForm(ActionEvent actionEvent){
        DeudorTable.setVisible(false);
        PrestamoTable.setVisible(false);
        Formulario.setVisible(true);

    }

    private void updateTable(TableView<Deudor> table, java.util.List<Deudor> lista) {
        table.getItems().clear();
        table.getItems().addAll(lista);
        table.refresh();
    }

    private void clearInputFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtIdNumber.clear();
        txtSaldo.clear();
        txtIdDate.clear();
        txtTypePrestamo.clear();
        txtIdNumber.setEditable(true);
    }

    private void loadInputFields(Deudor deudor) {
        txtFirstName.setText(deudor.getFirstName());
        txtLastName.setText(deudor.getLastName());
        txtIdNumber.setText(deudor.getIdNumber());
        txtSaldo.setText(deudor.getSaldo());
        txtIdDate.setText(deudor.getIdDate());
        txtIdNumber.setEditable(false);
    }

    private void fillDeudor(Deudor deudor) {
        deudor.setFirstName(txtFirstName.getText());
        deudor.setLastName(txtLastName.getText());
        deudor.setIdNumber(txtIdNumber.getText());
        deudor.setIdDate(txtIdDate.getText());
        deudor.setSaldo(txtSaldo.getText());
    }

    public void sumaSaldoP(){
        int sumaPrestamo = 0;
        for (Deudor deudor : prestamo.getListaDeudas()){

            sumaPrestamo+=deudor.getSaldoint();
        }
        saldoPrestado.setText(String.valueOf(sumaPrestamo));

    }












    public void SaldoDeuda(){
        int saldoDeudas = 0;
        for (Deudor prestamos : prestamo.getListaPrestamos()) {


            saldoDeudas+=prestamos.getSaldoint();
        }
        saldoDeuda.setText(String.valueOf(saldoDeudas));

    }
}
