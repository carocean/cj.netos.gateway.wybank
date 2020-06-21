package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.*;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

@CjConsumer(name = "workflow")
@CjService(name = "/workflow/event.mhub#doWorkItem")
public class CreateWYBankWorkflowCommand implements IConsumerCommand {
    @CjServiceRef
    IWenyBankService wenyBankService;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException, IOException {
        if (body == null) {
            CJSystem.logging().warn(getClass(), String.format("创建个狗屎，body为空:%s", properties.toString()));
            return;
        }
        WorkItem workItem = new Gson().fromJson(new String(body), WorkItem.class);
        WorkInst inst = workItem.getWorkInst();
        WorkEvent event = workItem.getWorkEvent();
        String formJson = event.getData();
        if (StringUtil.isEmpty(formJson)) {
            CJSystem.logging().warn(getClass(), String.format("创建个狗屎，工作事项:%s[%s] 的data为空。请求:%s", event.getTitle(), event.getId(), properties.toString()));
            return;
        }
        WyBankForm form = new Gson().fromJson(formJson, WyBankForm.class);
        wenyBankService.createWenyBankByForm(form);
    }
}
