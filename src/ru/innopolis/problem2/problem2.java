// your solution here
//fix all the errors including package errors
interface ICommand
{
    void Execute();
}

class Sell : ICommand{
    public void Execute(){
    }
}

class  Buy : ICommand{
    public void Execute(){
    }
}