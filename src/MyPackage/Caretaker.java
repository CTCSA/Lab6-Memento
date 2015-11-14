/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackage;
import java.util.*;

/**
 *
 * @author a1
 */
public class Caretaker {
    private Vector<Memento> undoList = new Vector();
    private Memento m;

    public Caretaker() {
    }
     
    public void saveMyClass(MyClass mc){
        m = new Memento(mc);
        this.undoList.add(m);
    }
    
    public void undo(){
       undoList.lastElement().restore();
       undoList.remove(undoList.lastElement());
    }
}
