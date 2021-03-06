package stu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.alibaba.fastjson.JSONObject;
import net.miginfocom.swing.*;
import org.apache.commons.lang3.StringEscapeUtils;
import stu.pojo.*;
/*
 * Created by JFormDesigner on Tue Mar 16 14:06:40 CST 2021
 */



/**
 * @author qipan
 */
public class ListView extends JFrame {
    public ListView() {
        initComponents();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(comboBox1.getSelectedIndex() == 0){
            print1();
        }else if(comboBox1.getSelectedIndex() == 1){
            print2();
        }else if(comboBox1.getSelectedIndex() == 2){
            print3();
        }else if(comboBox1.getSelectedIndex() == 3){
            print4();
        }else if(comboBox1.getSelectedIndex() == 4){
            print5();
        }else if(comboBox1.getSelectedIndex() == 5){
            print6();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - qipan
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        scrollPane3 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Table");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u6210\u679c\u7c7b\u578b\uff1a");
        contentPane.add(label1, "cell 8 0 3 1");

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        contentPane.add(comboBox1, "cell 12 0 8 1");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(table1);
        }
        contentPane.add(scrollPane3, "cell 0 1 41 17");
        setSize(1000, 565);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        comboBox1.addItem("????????????");
        comboBox1.addItem("????????????");
        comboBox1.addItem("????????????");
        comboBox1.addItem("?????????????????????");
        comboBox1.addItem("????????????");
        comboBox1.addItem("?????????????????????????????????");
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "??????", "????????????", "??????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(119);
        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1.getColumnModel().getColumn(2).setPreferredWidth(77);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<First> arrayList = new ArrayList<First>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\first.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                First first = new First();
                first.setType(jsonObject.getString("type"));
                first.setName(jsonObject.getString("name"));
                first.setStuid(jsonObject.getString("stuid"));
                first.setFlag(Integer.parseInt(jsonObject.getString("flag")));

                arrayList.add(first);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(First one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getType());
            v.add(one.getName());
            v.add(one.getStuid());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);
        }

        setcolor(table1,arrayList1,arrayList2);



    }

    void print1(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "??????", "????????????", "??????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(119);
        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1.getColumnModel().getColumn(2).setPreferredWidth(77);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<First> arrayList = new ArrayList<First>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\first.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                First first = new First();
                first.setType(jsonObject.getString("type"));
                first.setName(jsonObject.getString("name"));
                first.setStuid(jsonObject.getString("stuid"));
                first.setFlag(Integer.parseInt(jsonObject.getString("flag")));

                arrayList.add(first);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(First one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getType());
            v.add(one.getName());
            v.add(one.getStuid());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);

        }
        setcolor(table1,arrayList1,arrayList2);
    }

    void print2(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "????????????", "????????????", "??????","????????????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(119);
        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1.getColumnModel().getColumn(2).setPreferredWidth(77);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<Second> arrayList = new ArrayList<Second>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\second.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Second second = new Second();
                second.setType(jsonObject.getString("type"));
                second.setName(jsonObject.getString("name"));
                second.setStuid(jsonObject.getString("stuid"));
                second.setId(jsonObject.getString("id"));
                second.setFlag(Integer.parseInt(jsonObject.getString("flag")));

                arrayList.add(second);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(Second one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getType());
            v.add(one.getName());
            v.add(one.getStuid());
            v.add(one.getId());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);

        }

        setcolor(table1,arrayList1,arrayList2);
    }

    void print3(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "????????????", "????????????", "??????","????????????","??????????????????/???/??????","????????????????????????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(119);
        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1.getColumnModel().getColumn(2).setPreferredWidth(77);
        table1.getColumnModel().getColumn(3).setPreferredWidth(77);
        table1.getColumnModel().getColumn(4).setPreferredWidth(97);
        table1.getColumnModel().getColumn(5).setPreferredWidth(77);

        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<Third> arrayList = new ArrayList<Third>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\third.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Third third = new Third();
                third.setName(jsonObject.getString("name"));
                third.setStuid(jsonObject.getString("stuid"));
                third.setActionName(jsonObject.getString("actionName"));
                third.setTh(jsonObject.getString("th"));
                third.setData(jsonObject.getString("data"));
                third.setTel(jsonObject.getString("tel"));
                third.setFlag(Integer.parseInt(jsonObject.getString("flag")));

                arrayList.add(third);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(Third one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getName());
            v.add(one.getStuid());
            v.add(one.getActionName());
            v.add(one.getTh());
            v.add(one.getData());
            v.add(one.getTel());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }

            def.addRow(v);

        }
        setcolor(table1,arrayList1,arrayList2);
    }

    void print4(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                         "????????????", "??????","????????????","????????????","????????????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(77);
        table1.getColumnModel().getColumn(2).setPreferredWidth(119);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(4).setPreferredWidth(100);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<Forth> arrayList = new ArrayList<Forth>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\fourth.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Forth forth = new Forth();
                forth.setName(jsonObject.getString("name"));
                forth.setStuid(jsonObject.getString("stuid"));
                forth.setActName(jsonObject.getString("actName"));
                forth.setCmp(jsonObject.getString("cmp"));
                forth.setDesc(jsonObject.getString("desc"));
                forth.setFlag(Integer.parseInt(jsonObject.getString("flag")));


                arrayList.add(forth);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(Forth one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getName());
            v.add(one.getStuid());
            v.add(one.getActName());
            v.add(one.getCmp());
            v.add(one.getDesc());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);

        }
        setcolor(table1,arrayList1,arrayList2);
    }

    void print5(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "????????????", "??????","????????????","????????????","????????????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(77);
        table1.getColumnModel().getColumn(2).setPreferredWidth(119);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(4).setPreferredWidth(100);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<Fifth> arrayList = new ArrayList<Fifth>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\fifth.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Fifth fifth = new Fifth();
                fifth.setName(jsonObject.getString("name"));
                fifth.setStuid(jsonObject.getString("stuid"));
                fifth.setCardName(jsonObject.getString("cardName"));
                fifth.setCardId(jsonObject.getString("cardId"));
                fifth.setCardDate(jsonObject.getString("cardDate"));
                fifth.setFlag(Integer.parseInt(jsonObject.getString("flag")));


                arrayList.add(fifth);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(Fifth one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getName());
            v.add(one.getStuid());
            v.add(one.getCardName());
            v.add(one.getCardId());
            v.add(one.getCardDate());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);

        }
        setcolor(table1,arrayList1,arrayList2);
    }

    void print6(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "????????????", "??????","????????????","?????????????????????","????????????","???????????????","??????????????????","????????????"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setPreferredWidth(119);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(4).setPreferredWidth(50);
        table1.getColumnModel().getColumn(5).setPreferredWidth(50);
        table1.getColumnModel().getColumn(6).setPreferredWidth(100);
        table1.getColumnModel().getColumn(7).setPreferredWidth(100);
        scrollPane3.setViewportView(table1);

        //???????????????
        DefaultTableModel def = (DefaultTableModel) table1.getModel();
        def.setRowCount(0);
        //????????????
        ArrayList<Sixth> arrayList = new ArrayList<Sixth>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //????????????InputStreamReader,???????????????????????????BufferedReader??????????????????InputStreamReader?????????
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\sixth.txt");// FileInputStream
            // ????????????????????????????????????????????????
            isr = new InputStreamReader(fis);// InputStreamReader ????????????????????????????????????,
            br = new BufferedReader(isr);// ?????????????????????????????????????????????,???????????????new InputStreamReader?????????
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
                if(str.equals(""))continue;
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJava(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Sixth sixth = new Sixth();
                sixth.setName(jsonObject.getString("name"));
                sixth.setStuid(jsonObject.getString("stuid"));
                sixth.setActName(jsonObject.getString("actName"));
                sixth.setCmp(jsonObject.getString("cmp"));
                sixth.setTh(jsonObject.getString("th"));
                sixth.setManager(jsonObject.getString("manager"));
                sixth.setTel(jsonObject.getString("tel"));
                sixth.setDate(jsonObject.getString("date"));
                sixth.setFlag(Integer.parseInt(jsonObject.getString("flag")));



                arrayList.add(sixth);
            }


        } catch (FileNotFoundException e) {
            System.out.println("?????????????????????");
        } catch (IOException e) {
            System.out.println("??????????????????");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // ??????????????????????????????????????????????????????????????????????????????s,??????n,?????????m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i=0;
        for(Sixth one : arrayList) {
            i++;
            Vector v = new Vector();
            v.add(one.getName());
            v.add(one.getStuid());
            v.add(one.getActName());
            v.add(one.getCmp());
            v.add(one.getTh());
            v.add(one.getManager());
            v.add(one.getTel());
            v.add(one.getDate());
            if(one.getFlag()==1){
                arrayList1.add(i);
            }else if(one.getFlag()==2){
                arrayList2.add(i);
            }
            def.addRow(v);

        }
        setcolor(table1,arrayList1,arrayList2);
    }

    public static void setOneRowBackgroundColor(JTable table, int rowIndex,
                                                Color color) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

                public Component getTableCellRendererComponent(JTable table,
                                                               Object value, boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    if (row == rowIndex) {
                        setBackground(color);
                        setForeground(Color.WHITE);
                    }else if(row > rowIndex){
                        setBackground(Color.BLACK);
                        setForeground(Color.WHITE);
                    }else{
                        setBackground(Color.BLACK);
                        setForeground(Color.WHITE);
                    }

                    return super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                }
            };
            int columnCount = table.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setcolor (JTable table,ArrayList<Integer> pass,ArrayList<Integer> unpass){
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                                                               Object value, boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    if(pass.contains(row+1))
                        setBackground(Color.green);
                    else if(unpass.contains(row+1)){
                        setBackground(Color.red);
                    }else{
                        setBackground(Color.white);
                    }
                    return super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                }
            };
            for (int k = 0; k < table1.getColumnCount(); k++) {
                table1.getColumn(table1.getColumnName(k)).setCellRenderer(tcr);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }




    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - qipan
    private JLabel label1;
    private JComboBox comboBox1;
    private JScrollPane scrollPane3;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
