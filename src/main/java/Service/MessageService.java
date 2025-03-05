package Service;

import Model.Message;
import DAO.MessageDAO;
import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message) {
        if (message.getMessage_text().isBlank() || message.getMessage_text().length() > 255) 
            return null;
        return messageDAO.createMessage(message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageByID(int message_id) {
        return messageDAO.getMessageById(message_id);
    }

    public boolean deleteMessage(int message_id) {
        return messageDAO.deleteMessage(message_id);
    }

    public Message updateMessage(int message_id, String newText) {
        if (newText.isBlank() || newText.length() > 255)
            return null;
        Message oldText = messageDAO.getMessageById(message_id);
        if (oldText == null) 
            return null;
        boolean success = messageDAO.updateMessage(message_id, newText);
        if (success) 
            return messageDAO.getMessageById(message_id);
        return null;
    }

    public List<Message> getMessagesByUser(int account_id) {
        return messageDAO.getMessagesByUser(account_id);
    }
}
