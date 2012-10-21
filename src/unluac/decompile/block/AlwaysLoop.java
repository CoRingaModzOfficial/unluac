package unluac.decompile.block;

import java.util.ArrayList;
import java.util.List;

import unluac.decompile.Output;
import unluac.decompile.statement.Statement;

public class AlwaysLoop extends Block {
  
  private final List<Statement> statements;
  
  public AlwaysLoop(int begin, int end) {
    super(begin, end);
    statements = new ArrayList<Statement>();
  }
  
  @Override
  public boolean breakable() {
    return true;
  }
  
  @Override
  public boolean isContainer() {
    return true;
  }
  
  @Override
  public boolean isUnprotected() {
    return true;
  }
  
  @Override
  public int getLoopback() {
    return begin;
  }
  
  @Override
  public void print(Output out) {
    out.println("while true do");
    out.indent();
    Statement.printSequence(out, statements);
    out.dedent();
    out.print("end");
  }

  @Override
  public void addStatement(Statement statement) {
    statements.add(statement);
  }
}