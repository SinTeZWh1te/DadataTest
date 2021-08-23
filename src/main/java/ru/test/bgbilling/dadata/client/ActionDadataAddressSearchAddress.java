package ru.test.bgbilling.dadata.client;

import ru.bitel.bgbilling.client.BGClientBase;
import ru.bitel.bgbilling.client.common.BGTabPanel;
import ru.bitel.bgbilling.client.common.ClientContext;
import ru.bitel.bgbilling.client.util.ClientUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author sintezwh1te
 */
public class ActionDadataAddressSearchAddress implements ActionListener {

    public ActionDadataAddressSearchAddress() {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ClientContext clientContext = null;
        Component component = BGClientBase.getFrame().getTabbedPane().getSelectedTab();
        if (component instanceof BGTabPanel) {
            BGTabPanel panel = (BGTabPanel) component;
            if (panel.getTabId().startsWith("contract_")) {
                clientContext = panel.getContext();
            }
        }
        if (clientContext != null) {
            DadataActionSearchAddress dadataActionSearchAddress = new DadataActionSearchAddress(clientContext);
            dadataActionSearchAddress.setVisible(true);
            dadataActionSearchAddress.requestFocusInWindow();
        } else {
            ClientUtils.showErrorMessageDialog("Откройте карточку договора");
        }
    }
}
