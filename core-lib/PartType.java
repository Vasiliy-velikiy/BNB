


package Tests;
import java.util.ArrayList;
import java.util.List;

public class PartType{
    private int id; //индентификатор типа
    public ArrayList<Work> workflow; //порядок и время обработки детали.( через сколько и каких линий должна пройти деталь чтобы быть готовой)

    public PartType(int id ) {
        this.id = id;

    }
}
