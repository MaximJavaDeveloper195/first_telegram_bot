import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "my_first_musicc_bot";
    }

    @Override
    public String getBotToken() {
        return "5764799036:AAHoT6Am4cb7RZHLsH0htDnlI0W75_PTpfU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());



        /*String id = String.valueOf(update.getMessage().getPhoto());
        sendMessage.setText(id);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }*/



        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Headphones"));
        keyboardRow1.add(new KeyboardButton("Tokyo ghoul"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Eye"));
        keyboardRow2.add(new KeyboardButton("Piano"));
        keyboardRow2.add(new KeyboardButton("Car"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()){
            case "Eye" :
                inputFile.setMedia("AgACAgIAAxkBAAMIYzqQke8mrpOpyti6j4Oe8ZNXnIEAAk7AMRvKfrlJP3pQxl_oFCkBAAMCAANzAAMqBA");
                break;
            case "Tokyo ghoul" :
                inputFile.setMedia("AgACAgIAAxkBAAMKYzqQ8JSHbHoVUb44IMXfowgeV9gAAkDCMRvmC9BJwRaNnrwS8HkBAAMCAANzAAMqBA");
                break;
            case "Headphones" :
                inputFile.setMedia("AgACAgIAAxkBAAMMYzqRRFz6u0OV-SO8kWp3f88hmogAAkLCMRvmC9BJet0-fJUPfX8BAAMCAANzAAMqBA");
                break;
            case "Piano" :
                inputFile.setMedia("AgACAgIAAxkBAAMOYzqRbjyuRMCcPknEnbUCLjOKa8EAAkPCMRvmC9BJFZ7ZrE5wzgoBAAMCAANzAAMqBA");
                break;
            case "Car" :
                inputFile.setMedia("AgACAgIAAxkBAAMSYzqSAAHmN8p9FRlxUXDq4rUn862hAAJFwjEb5gvQSZUefWdNFGrcAQADAgADcwADKgQ");
                break;
        }
        sendPhoto.setPhoto(inputFile);
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
