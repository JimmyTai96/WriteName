public class WriteName{
  public static void main(String args[]){
    WriteName wn = new WriteName();

    wn.printLetter("Jimmy");
    System.out.println();
    wn.printLetter("Tai");
    /**
     * System.out.println();
     * wn.printLetter(bob)
     * System.out.println();
     */
  }




  private static class WriteLetter implements Runnable{
    public char letter;

    public WriteLetter(char a){
      letter = a;
    }

    @Override
    public void run(){
      System.out.print(letter + " ");
    }
  }

  public static void printLetter(String name){

    for(int i =0; i < name.length(); i++){
      WriteLetter letter = new WriteLetter(name.charAt(i)); 
      Thread t = new Thread(letter);
      t.start();
      try{
        t.join();
      }
      catch(InterruptedException ie){
        ie.printStackTrace();
      }
    }
  }
}
