/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class tabeldata_movie extends AbstractTableModel{
    List<data_movie> dm;
    public tabeldata_movie(List<data_movie>dm){
        this.dm = dm;
    }

    @Override
    public int getRowCount() {
        return dm.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dm.get(row).getJudul();
            case 1:
                return dm.get(row).getAlur();
            case 2:
                return dm.get(row).getPenokohan();
            case 3:
                return dm.get(row).getAkting();
            case 4:
                return dm.get(row).getMilai();
            default:
                return null;
        }
        
    }

}
