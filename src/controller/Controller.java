package controller;

public abstract class Controller  {
	public abstract void execute();
	public abstract String getDescription();
}

interface UndoRedoController{
	public void undo();
	public void redo();
}