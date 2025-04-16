using System;

public interface ICommand
{
    void Execute();
}

public class Message
{
    public static string text { get; set; } = string.Empty; 
}

public class Cin : ICommand
{
    public void Execute()
    {
        Console.Write("Введите строку: ");
        Message.text += Console.ReadLine(); 
    }
}

public class DeleteLastSign : ICommand
{
    public void Execute()
    {
        Message.text = Message.text.Remove(Message.text.Length - 1); 
        Console.WriteLine("Текст: " + Message.text); 
    }
}

public class TextRedactor
{
    private ICommand command;

    public void SetCommand(ICommand command)
    {
        this.command = command;
    }

    public void ExecuteThis()
    {
        command.Execute();
    }
}

class Program
{
    static void Main()
    {
        ICommand addSymbol = new Cin();
        ICommand deleteLastSign = new DeleteLastSign();

        TextRedactor remote = new TextRedactor();

        remote.SetCommand(addSymbol);
        remote.ExecuteThis();

        remote.SetCommand(deleteLastSign);
        remote.ExecuteThis();
    }
}
