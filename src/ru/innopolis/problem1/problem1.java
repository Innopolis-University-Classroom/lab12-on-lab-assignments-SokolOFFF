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
        }
}

class EmailLogger : Logger{
    protected override void WriteMessage(string msg){
        Console.WriteLine("Sending via email: " + msg);
    }
}

class FileLogger : Logger{
    protected override void WriteMessage(string msg){
        Console.WriteLine("Writing to Log File: " + msg);
        }
}
