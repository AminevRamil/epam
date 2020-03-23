/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для парсинга комманд удаления и печати
 *
 */
public class ParseCommand {

    /**
     * Парсит комманду удаления и печати строки
      * @param str комманда
     * @return экземпляр класса CommandArgs который содержит распарсенную строку по полям
     * lineNumber, fileName, command, text
     */
    public CommandArgs parsePrintDeleteCommand(String str){
        //вынести в отдельное поле
        CommandArgs ca = new CommandArgs();
        String parameters[] = str.split(" ");

        //Если удаляем
        if (parameters[0].equals("delete")) {
            ca.command = "delete";
            //Если переданно имя файла
            if (parameters.length > 2) {
                ca.lineNumber = parameters[1];
                ca.fileName = parameters[2];
            } else {
                ca.lineNumber = null;
                ca.fileName = parameters[1];
            }
        }

        //Если распечатываем
        if (parameters[0].equals("print")) {
            ca.command = "print";
            //Если переданно имя файла
            if (parameters.length> 2) {
                ca.lineNumber = parameters[1];
                ca.fileName = parameters[2];
            } else {
                ca.lineNumber = null;
                ca.fileName = parameters[1];
            }
        }

        return ca;
    }

    /**
     *
     ** Парсит комманду добавления строки
     *       * @param str комманда
     *      * @return экземпляр класса CommandArgs который содержит распарсенную строку по полям
     *      * lineNumber, fileName, command, text
     */
    public CommandArgs parseAddCommand(String str){
        CommandArgs ca = new CommandArgs();

        ca.command="add";


        int separateIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='"'){
                separateIndex = i;
                break;
            }
        }

        if (separateIndex==-1){
            try {
                throw new InvalidCommandException("Строка команды имеет неверный формат");
            }catch(InvalidCommandException e){
                System.out.println("Строка команды имеет неверный формат");
            }

            ca.text=null;
        }
        else {

            String subStringWithoutSeparator = str.substring(0, separateIndex);
            String subStringWithSeparator = str.substring(separateIndex);
            String[] arrString = subStringWithoutSeparator.split(" ");
            int index = 1;
            //String secondArgument = arrString[index++];
            String secondArgument = arrString[index];

            int linesCount = -1;
            String fileName = null;
            String text = null;

            if (secondArgument.matches("\\d+") && arrString.length > 2) {
                linesCount = Integer.valueOf(secondArgument);
                ca.lineNumber = String.valueOf(linesCount);
                index++;
            }

            if (secondArgument.matches("[-]\\d+") && arrString.length > 2) {
                linesCount = 0;
                ca.lineNumber = "-2";
                index++;
            }


            fileName = arrString[index++];
            ca.fileName = fileName;


            text = subStringWithSeparator.replace("\"", "");
            ca.text = text;
        }//end else  if (separateIndex==-1)

        return ca;
    }
}
