import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Converter extends JFrame {


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JCheckBox CheckBox2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JPanel jPanel2;
    private JSpinner jSpinner1;
    private JTextField jTextField1;
    private JTextField jTextField2;


    public Converter ( ) throws IOException {
        initComponents ();
    }

    public static void main ( String[] args ) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels ()) {
                if ( "Nimbus".equals ( info.getName () ) ) {
                    UIManager.setLookAndFeel ( info.getClassName () );
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger ( Converter.class.getName () ).log ( java.util.logging.Level.SEVERE , null , ex );
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger ( Converter.class.getName () ).log ( java.util.logging.Level.SEVERE , null , ex );
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger ( Converter.class.getName () ).log ( java.util.logging.Level.SEVERE , null , ex );
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger ( Converter.class.getName () ).log ( java.util.logging.Level.SEVERE , null , ex );
        }
        EventQueue.invokeLater ( new Runnable () {
            public void run ( ) {
                try {
                    new Converter ().setVisible ( true );
                } catch (IOException e) {
                    throw new RuntimeException ( e );
                }
            }
        } );
    }

    private void initComponents ( ) throws IOException {

        CheckBox2 = new JCheckBox ();
        jSpinner1 = new JSpinner ();
        jPanel2 = new BackroundPanel ();
        jLabel1 = new JLabel ();
        jComboBox1 = new JComboBox<> ();
        jComboBox2 = new JComboBox<> ();
        jTextField1 = new JTextField ();
        jTextField2 = new JTextField ();
        button1 = new JButton ();
        button2 = new JButton ();
        button3 = new JButton ();

        CheckBox2.setText ( "CheckBox2" );

        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        setTitle ( "Converter " );
        BufferedImage image = ImageIO.read(new File ("src/main/resources/image1.png"));
        setIconImage (image);


        jLabel1.setBackground ( new Color ( 21 , 173 , 130 ) );
        jLabel1.setFont ( new Font ( "Segoe UI Italic" , 3 , 24 ) );
        jLabel1.setForeground ( new Color ( 0 , 0 , 0 , 255 ) );
        jLabel1.setText ( "Metric Converter " );

        GroupLayout jPanel2Layout = new GroupLayout ( jPanel2 );
        jPanel2.setLayout ( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup (
                jPanel2Layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                        .addGroup ( jPanel2Layout.createSequentialGroup ()
                                .addGap ( 142 , 142 , 142 )
                                .addComponent ( jLabel1 )
                                .addContainerGap ( 161 , Short.MAX_VALUE ) )
        );
        jPanel2Layout.setVerticalGroup (
                jPanel2Layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                        .addGroup ( jPanel2Layout.createSequentialGroup ()
                                .addGap ( 19 , 19 , 19 )
                                .addComponent ( jLabel1 )
                                .addContainerGap ( 23 , Short.MAX_VALUE ) )
        );

        jComboBox1.setModel ( new DefaultComboBoxModel<> ( new String[]{"Millimeter" , "Centimeter" , "Meter" , "Kilometer"} ) );

        jComboBox2.setModel ( new DefaultComboBoxModel<> ( new String[]{"Millimeter" , "Centimeter" , "Meter" , "Kilometer"} ) );


        jTextField2.setEditable ( false );

        button1.setFont ( new Font ( "Segoe UI" , 3 , 14 ) ); // NOI18N
        button1.setText ( "Convert" );
        button1.addActionListener ( new ActionListener () {
            public void actionPerformed ( ActionEvent evt ) {
                calculations ( evt );
            }
        } );

        button2.setFont ( new Font ( "Segoe UI" , 3 , 14 ) ); // NOI18N
        button2.setText ( "Clear" );
        button2.addActionListener ( new ActionListener () {
            public void actionPerformed ( ActionEvent evt ) {
                settingTheInputFields ( evt );
            }
        } );

        button3.setFont ( new Font ( "Segoe UI" , 3 , 14 ) ); // NOI18N
        button3.setText ( "Exit" );
        button3.addActionListener ( new ActionListener () {
            public void actionPerformed ( ActionEvent evt ) {
                theExitButtonClicked ( evt );
            }
        } );

        GroupLayout layout = new GroupLayout ( getContentPane () );
        getContentPane ().setLayout ( layout );
        layout.setHorizontalGroup (
                layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                        .addGroup ( layout.createSequentialGroup ()
                                .addGap ( 50 , 50 , 50 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.LEADING , false )
                                        .addComponent ( jComboBox2 , 0 , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
                                        .addComponent ( jComboBox1 , 0 , 116 , Short.MAX_VALUE ) )
                                .addGap ( 133 , 133 , 133 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                                        .addComponent ( jTextField1 , GroupLayout.PREFERRED_SIZE , 97 , GroupLayout.PREFERRED_SIZE )
                                        .addComponent ( jTextField2 , GroupLayout.PREFERRED_SIZE , 97 , GroupLayout.PREFERRED_SIZE ) )
                                .addContainerGap ( GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE ) )
                        .addGroup ( GroupLayout.Alignment.TRAILING , layout.createSequentialGroup ()
                                .addContainerGap ( GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
                                .addComponent ( button1 )
                                .addGap ( 30 , 30 , 30 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                                        .addComponent ( button3 )
                                        .addComponent ( button2 ) )
                                .addGap ( 29 , 29 , 29 ) )
                        .addComponent ( jPanel2 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
        );
        layout.setVerticalGroup (
                layout.createParallelGroup ( GroupLayout.Alignment.LEADING )
                        .addGroup ( layout.createSequentialGroup ()
                                .addComponent ( jPanel2 , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE )
                                .addGap ( 46 , 46 , 46 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.BASELINE )
                                        .addComponent ( jComboBox1 , GroupLayout.PREFERRED_SIZE , 34 , GroupLayout.PREFERRED_SIZE )
                                        .addComponent ( jTextField1 , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE ) )
                                .addGap ( 3 , 3 , 3 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.BASELINE )
                                        .addComponent ( button1 )
                                        .addComponent ( button2 ) )
                                .addGap ( 18 , 18 , 18 )
                                .addGroup ( layout.createParallelGroup ( GroupLayout.Alignment.BASELINE )
                                        .addComponent ( jComboBox2 , GroupLayout.PREFERRED_SIZE , 33 , GroupLayout.PREFERRED_SIZE )
                                        .addComponent ( jTextField2 , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap ( LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
                                .addComponent ( button3 )
                                .addGap ( 37 , 37 , 37 ) )

        );

        pack ();
    }

    private void theExitButtonClicked ( ActionEvent evt ) {
        System.exit ( 0 );


    }

    private void settingTheInputFields ( ActionEvent evt ) {

        jTextField1.setText ( "" );
        jTextField2.setText ( "" );
    }

    private void calculations ( ActionEvent evt ) {
        String val1 = (String) jComboBox1.getSelectedItem ();
        String val2 = (String) jComboBox2.getSelectedItem ();

        //mili-centim
        if ( val1.equals ( "Millimeter" ) && val2.equals ( "Centimeter" ) ) {
            double milim = Double.parseDouble ( jTextField1.getText () );
            double centim = milim * milim / 10;

            jTextField2.setText ( String.valueOf ( centim ) );
        } else if ( val1.equals ( "Millimeter" ) && val2.equals ( "Millimeter" ) ) {
            int c = (int) Double.parseDouble ( jTextField1.getText () );

            jTextField2.setText ( String.valueOf ( c ) );
        }
        if ( val1.equals ( "Centimeter" ) && val2.equals ( "Millimeter" ) ) {
            double centimet = Double.parseDouble ( jTextField1.getText () );

            double milimet = (centimet * 10);

            jTextField2.setText ( String.valueOf ( Math.round ( milimet ) ) );
        } else if ( val1.equals ( "Centimeter" ) && val2.equals ( "Centimeter" ) ) {
            double f = Double.parseDouble ( jTextField1.getText () );

            jTextField2.setText ( String.valueOf ( Math.round ( f ) ) );
        }

        //centim-meter
        if ( val1.equals ( "Centimeter" ) && val2.equals ( "Meter" ) ) {
            double cent = Double.parseDouble ( jTextField1.getText () );
            double m = cent * cent / 100;

            jTextField2.setText ( String.valueOf ( m ) );
        }

        if ( val1.equals ( "Meter" ) && val2.equals ( "Centimeter" ) ) {
            int metru = Integer.parseInt ( (jTextField1.getText ()) );

            int centimet = ((metru * 100));

            jTextField2.setText ( String.valueOf ( (centimet) ) );
        } else if ( val1.equals ( "Meter" ) && val2.equals ( "Meter" ) ) {
            double f = Double.parseDouble ( jTextField1.getText () );

            jTextField2.setText ( String.valueOf ( Math.round ( f ) ) );
        }

        // meter-kilomet
        if ( val1.equals ( "Meter" ) && val2.equals ( "Kilometer" ) ) {
            double mo = Double.parseDouble ( jTextField1.getText () );
            double kilomomo = mo * mo / 1000;

            jTextField2.setText ( String.valueOf ( kilomomo ) );
        } else if ( val1.equals ( "Kilometer" ) && val2.equals ( "Kilometer" ) ) {
            double c = Double.parseDouble ( jTextField1.getText () );

            jTextField2.setText ( String.valueOf ( Math.round ( c ) ) );
        }
        if ( val1.equals ( "Kilometer" ) && val2.equals ( "Meter" ) ) {
            int kilom = Integer.parseInt ( (jTextField1.getText ()) );

            int melo = ((kilom * 1000));

            jTextField2.setText ( String.valueOf ( (melo) ) );
        }

        if ( val1.equals ( "Millimeter" ) && val2.equals ( "Meter" ) ) {
            double milim = Double.parseDouble ( jTextField1.getText () );
            double meter = milim / 1000;

            jTextField2.setText ( String.valueOf ( meter ) );
        } else if ( val1.equals ( "Meter" ) && val2.equals ( "Millimeter" ) ) {
            double meter = Double.parseDouble ( jTextField1.getText () );
            double milim = meter * 1000;

            jTextField2.setText ( String.valueOf ( milim ) );
        }

        if ( val1.equals ( "Centimeter" ) && val2.equals ( "Kilometer" ) ) {
            double cm = Double.parseDouble ( jTextField1.getText () );
            double km = cm / 100000;

            jTextField2.setText ( String.valueOf ( km ) );
        } else if ( val1.equals ( "Kilometer" ) && val2.equals ( "Centimeter" ) ) {
            double km = Double.parseDouble ( jTextField1.getText () );
            double cm = km * 100000;

            jTextField2.setText ( String.valueOf ( cm ) );
        }

        if ( val1.equals ( "Millimeter" ) && val2.equals ( "Kilometer" ) ) {
            double milim = Double.parseDouble ( jTextField1.getText () );
            double km = milim / 1000000;

            jTextField2.setText ( String.valueOf ( km ) );
        } else if ( val1.equals ( "Kilometer" ) && val2.equals ( "Millimeter" ) ) {
            double km = Double.parseDouble ( jTextField1.getText () );
            double milim = km * 1000000;

            jTextField2.setText ( String.valueOf ( milim ) );
        }


    }


}