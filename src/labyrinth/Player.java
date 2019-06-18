/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WCHR
 */
public class Player implements Serializable {

    Object name;
    Object result;
    int level;

    public Player(Object name, Object result, int level) {
        this.name = name;
        this.result = result;
        this.level = level;
    }

    public String toString() {
        return (name + ">" + result + ">" + level);
    }

    public static Player recognise(String s) {
        Matcher m = Pattern.compile("(\\w+)>([\\w\\s:]+)>([123])").matcher(s);
        if (m.find()) {
            return new Player(m.group(1), m.group(2), Integer.parseInt(m.group(3)));
        } else {
            return null;
        }
    }
}
