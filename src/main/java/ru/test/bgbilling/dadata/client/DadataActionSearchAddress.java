package ru.test.bgbilling.dadata.client;

import bitel.billing.module.common.*;
import ru.bitel.bgbilling.client.common.BGTextField;
import ru.bitel.bgbilling.client.common.BGTitleBorder;
import ru.bitel.bgbilling.client.common.ClientContext;
import ru.bitel.bgbilling.client.util.ClientUtils;
import ru.bitel.bgbilling.common.BGException;
import ru.bitel.bgbilling.common.BGMessageException;
import ru.bitel.bgbilling.kernel.contract.api.common.service.ContractParameterService;
import ru.bitel.common.Utils;
import ru.bitel.common.client.BGButtonPanel;
import ru.bitel.common.client.BGButtonPanelOkCancel;
import ru.bitel.oss.kernel.entity.common.bean.EntitySpecAttrType;
import ru.test.bgbilling.dadata.common.bean.Suggestion;
import ru.test.bgbilling.dadata.common.bean.address.Address;
import ru.test.bgbilling.dadata.common.bean.address.QcGeo;
import ru.test.bgbilling.dadata.common.DadataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sintezwh1te
 */
public class DadataActionSearchAddress extends BGDialog {

    private final ClientContext context;
    private BGTextArea additionalParams = new BGTextArea();
    private BGComboBoxWithSearch addressCombo = new BGComboBoxWithSearch(5);
    private Suggestion<Address> selectedAddress;
    private BGTextField comment = new BGTextField();
    private BGTextField flat = new BGTextField();
    private IntTextField pod = new IntTextField();
    private IntTextField floor = new IntTextField();
    private BGControlPanelListSelect paramsList = new BGControlPanelListSelect();
    private BGButtonPanelOkCancel buttonPanel = new BGButtonPanelOkCancel();

    private DadataService dadataService;
    private ContractParameterService contractParameterService;

    public DadataActionSearchAddress(ClientContext clientContext) {
        this.context = clientContext;
        this.pack();
        this.setSize(600, 600);
        this.moveWindowToCenterScreen();
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Dadata");
        this.fillParamsList();
        this.addressCombo.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("fillText")) {
                    DadataActionSearchAddress.this.fillStreetList(String.valueOf(evt.getNewValue()));
                } else if (evt.getPropertyName().equals("textEntered")) {
                    DadataActionSearchAddress.this.fillAdditionalParam();
                }
            }
        });
        JButton buttonMap = new JButton();
        buttonMap.setText("Показать на карте");
        buttonMap.setActionCommand("showOnMap");
        buttonMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DadataActionSearchAddress.this.showOnMap(e);
            }
        });
        this.buttonPanel.add(buttonMap);
        this.buttonPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                DadataActionSearchAddress.this.buttonPanelActionPerformed(actionEvent);
            }
        });

        JPanel addressPanel = new JPanel(new GridBagLayout());
        addressPanel.setBorder(new BGTitleBorder(" Город, улица, дом "));
        addressPanel.add(this.addressCombo, new GridBagConstraints(0, 0, 6, 1, 1.0D, 0.0D, 11, 1, new Insets(0, 5, 5, 5), 0, 0));
        this.addressCombo.setEditable(true);
        addressPanel.add(new JLabel("Комментарий: "), new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(this.comment, new GridBagConstraints(1, 1, 5, 1, 1.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(new JLabel("Квартира: "), new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(this.flat, new GridBagConstraints(1, 2, 1, 1, 1.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(new JLabel("Подъезд: "), new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(this.pod, new GridBagConstraints(3, 2, 1, 1, 1.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(new JLabel("Этаж: "), new GridBagConstraints(4, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        addressPanel.add(this.floor, new GridBagConstraints(5, 2, 1, 1, 1.0D, 0.0D, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        //this.paramsList.setButtonPanelVisible(false);
        this.paramsList.setPreferredSize(new Dimension(0, 100));
        this.paramsList.setBorder(new BGTitleBorder(" Выберите параметры для заполнения "));

        JPanel additionalParamsPanel = new JPanel(new GridBagLayout());
        additionalParamsPanel.setBorder(new BGTitleBorder(" Дополнительные параметры "));
        JScrollPane jScrollPane = new JScrollPane(this.additionalParams, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new Dimension(0, 150));
        additionalParamsPanel.add(jScrollPane, new GridBagConstraints(0, 0, 1, 1, 1.0D, 0.0D, 10, 1, new Insets(0, 5, 5, 5), 0, 0));
        this.additionalParams.setEditable(false);
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(addressPanel, new GridBagConstraints(0, 0, 1, 1, 1.0D, 1.0D, 11, 1, new Insets(0, 5, 5, 5), 0, 0));
        this.getContentPane().add(this.paramsList, new GridBagConstraints(0, 1, 1, 1, 1.0D, 1.0D, 11, 1, new Insets(0, 5, 5, 5), 0, 0));
        this.getContentPane().add(additionalParamsPanel, new GridBagConstraints(0, 2, 1, 1, 1.0D, 3.0D, 11, 1, new Insets(0, 5, 5, 5), 0, 0));
        this.getContentPane().add(this.buttonPanel, new GridBagConstraints(0, 3, 1, 1, 1.0D, 0.0D, 15, 1, new Insets(10, 10, 10, 10), 0, 0));
    }

    private void buttonPanelActionPerformed(ActionEvent actionEvent) {
        if (BGButtonPanel.OK.getActionCommand().equals(actionEvent.getActionCommand())) {
            try {
                List<Integer> paramsListIds = this.paramsList.getListIds();
                if (paramsListIds.isEmpty()) {
                    ClientUtils.showMessageDialog("Выберите параметр для заполнения");
                    return;
                }
                if (this.selectedAddress == null) {
                    ClientUtils.showMessageDialog("Укажите адрес");
                    return;
                }
                if (!this.pod.getText().isEmpty() && Utils.parseInt(this.pod.getText(), -1) == -1) {
                    ClientUtils.showMessageDialog("\"Подъезд\" слишком большое число");
                    return;
                }
                if (!this.floor.getText().isEmpty() && Utils.parseInt(this.floor.getText(), -1) == -1) {
                    ClientUtils.showMessageDialog("\"Этаж\" слишком большое число");
                    return;
                }
                this.getDadataService().updateContractParam(this.selectedAddress, context.getContractId(), paramsListIds, Utils.maskNull(this.comment.getText()), Utils.maskNull(this.flat.getText()), Utils.parseInt(this.pod.getText()), Utils.parseInt(this.floor.getText()));
            } catch (BGMessageException e) {
                ClientUtils.showErrorMessageDialog(e);
            }
            this.setVisible(false);
            this.dispose();
        } else if (BGButtonPanel.CANCEL.getActionCommand().equals(actionEvent.getActionCommand())) {
            this.setVisible(false);
            this.dispose();
        }
    }

    private void fillParamsList() {
        try {
            ClientUtils.buildList(this.paramsList.getList(), this.getContractParameterService().contractParameterGroupAttrList().stream().filter(e -> e.getType() == EntitySpecAttrType.ADDRESS.getCode()).collect(Collectors.toList()));
        } catch (BGException e) {
            ClientUtils.showErrorMessageDialog(e);
        }
    }

    private void showOnMap(ActionEvent e) {
        if (this.selectedAddress != null) {
            try {
                //Suggestion<Address> address = this.getDadataService().getAddress(this.selectedAddress);
                if (selectedAddress == null) {
                    ClientUtils.showErrorMessageDialog("Укажите адрес");
                    return;
                }
                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("http://maps.yandex.ru/?text=" + selectedAddress.getData().getGeoLat() + "," + selectedAddress.getData().getGeoLon()));
                }
            } catch (Exception ex) {
                ClientUtils.showErrorMessageDialog(ex);
            }
        }
    }

    private void fillStreetList(String streetTitle) {
        try {
            this.addressCombo.initPopup(streetTitle);
            getDadataService().suggestAddress(streetTitle).forEach(value -> this.addressCombo.addItem(new ComboBoxItem(value, value.getUnrestrictedValue())));
        } catch (BGException e) {
            ClientUtils.showErrorMessageDialog(e);
        }
    }

    private void fillAdditionalParam() {
        this.selectedAddress = (Suggestion<Address>) this.addressCombo.getSelectedItem().getObject();
        if (this.selectedAddress != null) {
            StringBuilder sb = new StringBuilder();
            //Suggestion<Address> address = this.getDadataService().getAddress(this.selectedAddress);
            sb.append("Индекс: ").append(selectedAddress.getData().getPostalCode()).append("\n");
            sb.append("Код ФИАС: ").append(selectedAddress.getData().getFiasId()).append("\n").append(selectedAddress.getData().getFiasCode()).append("\n");
            sb.append("Координаты: ").append(selectedAddress.getData().getGeoLat()).append(",").append(selectedAddress.getData().getGeoLon()).append(" (").append(QcGeo.getById(Integer.parseInt(selectedAddress.getData().getQcGeo())).getTitle()).append(")\n");
            if (selectedAddress.getData().getHistoryValues() != null && !selectedAddress.getData().getHistoryValues().isEmpty()) {
                sb.append("Бывшие наименования: ").append(Utils.toString(selectedAddress.getData().getHistoryValues()));
            }
            this.additionalParams.setText(sb.toString());
        }
    }

    private DadataService getDadataService() {
        if (this.dadataService == null) {
            this.dadataService = (DadataService) context.getPort(DadataService.class);
        }
        return this.dadataService;
    }

    private ContractParameterService getContractParameterService() {
        if (this.contractParameterService == null) {
            this.contractParameterService = (ContractParameterService) context.getPort(ContractParameterService.class);
        }
        return this.contractParameterService;
    }
}
