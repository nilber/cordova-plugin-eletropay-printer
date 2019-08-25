package com.eletropay.printer;


public class PrinterCommand{
    public String Text;
    public int Size;
    public int Type;
    public int Alignment;

    public PrinterCommand(String text, int size,int type, int alignment){
        this.Text = text;
        this.Size = size;
        this.Type = type; // 0 = Text / 1 = Image / 2 = BlankLines
        this.Alignment = alignment;
    }
}