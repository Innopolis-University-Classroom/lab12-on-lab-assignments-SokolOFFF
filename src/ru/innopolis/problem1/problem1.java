// your solution here
//fix all the errors including package errors
package ru.innopolis;
abstract class Logger
{
    protected Logger next;
    public void Message(string msg) {
            WriteMessage(msg);
    }
    public Logger SetNext(Logger nextlogger)
    {
        Logger lastLogger = this;

        while (lastLogger.next != null) {
            lastLogger = lastLogger.next;
        }

        lastLogger.next = nextlogger;
        return this;
    }

    abstract protected void WriteMessage(string msg);
}

class ConsoleLogger : Logger{
        protected override void WriteMessage(string msg){
            Console.WriteLine("Writing to console: " + msg);
            next.WriteMessage(msg);
        }
}

class ServerLogger : Logger{
    protected override void WriteMessage(string msg){
        Console.WriteLine("Sending to server: " + msg);
        next.WriteMessage(msg);
    }
}

class FileLogger : Logger{
    protected override void WriteMessage(string msg){
        Console.WriteLine("Writing to Log File: " + msg);
        next.WriteMessage(msg);
    }
}

public class problem1{
    public static void main(String[] args) {
        Logger msgToConsole = new ConsoleLogger();
        Logger msgToFile = new FileLogger();
        Logger msgTOServer = new ServerLogger();
        msgToConsole.SetNext(msgToFile);
        msgToFile.SetNext(msgTOServer);
        msgToConsole.WriteMessage("Hello!");
    }
}
