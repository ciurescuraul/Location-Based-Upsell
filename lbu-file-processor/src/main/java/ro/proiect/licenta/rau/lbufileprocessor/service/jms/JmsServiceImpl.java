package ro.proiect.licenta.rau.lbufileprocessor.service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public class JmsServiceImpl implements JmsService {

    private final JmsConfig jmsConfig;

    @Autowired
    public JmsServiceImpl(JmsConfig jmsConfig) {
        this.jmsConfig = jmsConfig;
    }

    @Override
    public void enqueueCall(VoiceCallDetails callDetails) {
        // TODO Auto-generated method stub
    }
}
