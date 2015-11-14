/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackage;

/**
 *
 * @author a1
 */
public class Memento {
    private MyClass myClass;
    private int mState;

    public Memento(MyClass mc) {
        this.myClass = mc;
        this.mState = myClass.getState();
    }
    
    public void restore(){
        myClass.state = this.mState;
}
    
//    
}
