package contadorDeCaracteres;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.Cursor;

public class ContadorDeCaracteres extends JFrame {

	private JPanel contentPane;
	private ScrollPane scrollPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContadorDeCaracteres frame = new ContadorDeCaracteres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ContadorDeCaracteres() {

		setTitle("Contador de Caracteres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 603, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_IngreseTexto = new JLabel("Ingrese el texto aquí:");
		lbl_IngreseTexto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IngreseTexto.setBounds(32, 26, 137, 19);
		panel.add(lbl_IngreseTexto);
		
		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setForeground(Color.RED);
		lblCantidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCantidad.setBounds(499, 20, 70, 25);
		panel.add(lblCantidad);
		
		scrollPane = new ScrollPane();
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setIgnoreRepaint(true);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		scrollPane.setBounds(32, 51, 546, 120);
		panel.add(scrollPane);
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setLineWrap(true);
		
		textArea.setToolTipText("");
		textArea.setIgnoreRepaint(true);
		textArea.setInheritsPopupMenu(true);
		textArea.setLocation(new Point(0, 20));
		textArea.setBounds(32, 51, 537, 110);
		scrollPane.add(textArea); 
	
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.addKeyListener(new KeyAdapter() {
			int cant = 0;
			@Override
			public void keyTyped(KeyEvent e) {
				cant = textArea.getText().length();		
				lblCantidad.setText(String.valueOf(cant));
			}	
		});
		textArea.setColumns(10);	 
	
		JLabel lbl_textoAyuda = new JLabel("Puedes usar este:");
		lbl_textoAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_textoAyuda.setBounds(32, 199, 137, 13);
		panel.add(lbl_textoAyuda);
		
		JTextArea txt_texto = new JTextArea("Texto ayuda");
		txt_texto.setEditable(false);
		txt_texto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txt_texto.setBackground(SystemColor.control);
		txt_texto.setBounds(32, 222, 376, 61);
		panel.add(txt_texto);
		String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed sagittis quam, nec porta \n"
				+ "mauris. Integer eu mi dapibus, dictum elit quis, tempor sem. Donec vel tristique metus. Nam vel \n"
				+ "libero id erat vulputate ultrices.";
		txt_texto.setText(texto);
		
		JLabel lblEtiquetaCantidad = new JLabel("Caracteres:");
		lblEtiquetaCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEtiquetaCantidad.setBounds(429, 28, 75, 15);
		panel.add(lblEtiquetaCantidad);
		
		JLabel lblVersion = new JLabel("v1.0");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblVersion.setForeground(Color.LIGHT_GRAY);
		lblVersion.setVerticalAlignment(SwingConstants.TOP);
		lblVersion.setBounds(543, 293, 27, 19);
		panel.add(lblVersion);
	}
}
