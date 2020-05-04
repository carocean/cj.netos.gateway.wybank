package cj.netos.gateway.wybank.ports;

import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "/wybank.ports")
public class WYBankPorts implements IWYBankPorts {
    @CjServiceRef(refByName = "rabbitMQProducer")
    IRabbitMQProducer rabbitMQ;

    @Override
    public void purchase(ISecuritySession securitySession) throws CircuitException {

    }

    @Override
    public void exchange(ISecuritySession securitySession) throws CircuitException {

    }
}
