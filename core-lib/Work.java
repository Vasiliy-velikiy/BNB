
package Tests;
//объект произовдственной линии
public class Work{
   private int line; //линия
   private int time ;//время обработки


    public int getLine() {
        return line;
    }

    public int getTime() {
        return time;
    }

    public Work(int line, int time){
        this.line=line;
        this.time=time;
    }
}