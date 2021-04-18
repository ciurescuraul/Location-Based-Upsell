package ro.proiect.licenta.rau.lbufileprocessor.service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public class JmsServiceImpl implements JmsService {

    @Autowired
    private JmsConfig jmsConfig;

    @Override
    public boolean enqueueCall(VoiceCallDetails callDetails) {
        // TODO Auto-generated method stub

        boolean enqued = true;

        return enqued;
    }
}
