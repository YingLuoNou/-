package ͼƬ���ƴ��ڰ�;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MAIN extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean hz = false;//�Ƿ��Ѿ�����
	BufferedImage bi,bi2;
	Component tu = new Panel();
	JRadioButton jr1 =new JRadioButton("�ڰ�ģʽ",true);
	JRadioButton jr2 =new JRadioButton("ԭͼ�Ҷ�");
	JRadioButton jr3 =new JRadioButton("�ԱȻҶ�");
	Frame left = new JFrame("������");
	JLabel huidu = new JLabel("�Ҷ���ֵ");
	TextField hd = new TextField("10");//�Ҷ���ֵ����
	JLabel yz = new JLabel("��ֵ");
	TextField yuz = new TextField("50");//��ֵ����
	Checkbox graymode = new Checkbox("�Ҷ�ģʽ",false);//�Ҷ�ģʽѡ��
	JLabel sr = new JLabel("����(Ĭ��100��ԽСЧ��Խ���� )");
	//MAIN frame = new MAIN();
	Button bu = new Button("ѡ���ļ�");
	Button bu2 = new Button("����");
	Button bu3 = new Button("����");
	JLabel TiShi = new JLabel("����...");
	BufferedImage bufferedImage;
	JLabel sf = new JLabel("Ԥ������");
	JSlider js = new JSlider();//�������
	    int r,g,b; // �ֱ�������Ż�ȡ��RGBֵ
	    int h,w;//�� ��
	    //int id = 0;
	    int Graymode = 0;//�Ҷ�ģʽ 0���ر� 1��ԭͼ�Ҷ� 2���ԱȻҶ�
	    int grayyuzhi = 10;//�Ҷ���ֵ�������ɸ���
	    int yuzhi = 50;//��ֵ
	    String dq = "";//��ȡ·��
	    String bc = "";//����·��
	    public void start() {
	    	//��ʼ��
	    	try {
	            bufferedImage = ImageIO.read(new File(dq));
	            //ͼƬ��ַ
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    	h = bufferedImage.getHeight();
			w = bufferedImage.getWidth();
			bijiao();
	    }
	    
	    public MAIN(){
	    	add(tu);
	    	//��Ļ�ֱ��ʿ��
	    	int screenW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	    	//��Ļ�ֱ��ʸ߶�
	    	int screenH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	    	setTitle("��ͼ");
	    	setBounds((screenW/2)-350, (screenH/2)-400, 700, 800);
	    	js.setMaximum(200);
	    	js.setValue(100);
	    	js.setMinimum(1);
	    	
	    	Font font = new Font("����", Font.BOLD, 50);
	    	Font font2 = new Font("����", Font.BOLD, 18);
	    	yz.setHorizontalAlignment(SwingConstants.CENTER);
	    	huidu.setHorizontalAlignment(SwingConstants.CENTER);
	    	jr1.setFont(font2);
	    	jr2.setFont(font2);
	    	jr3.setFont(font2);
	    	sf.setFont(font2);
	    	ButtonGroup group = new ButtonGroup();
	    	group.add(jr1);
	    	group.add(jr2);
	    	group.add(jr3);
	    	
	    	
	    	yz.setFont(font2);
	    	yuz.setFont(font);
	    	huidu.setFont(font2);
	    	hd.setFont(font);
	    	graymode.setFont(font2);
	    	bu.setFont(font2);
	    	bu2.setFont(font2);
	    	bu3.setFont(font2);
	    	left.setResizable(false);
	    	left.add(yz);
	    	left.add(yuz);
	    	left.add(huidu);
	    	left.add(hd);
	    	left.add(jr1);
	    	left.add(jr2);
	    	left.add(jr3);
	    	left.add(bu);
	    	left.add(bu2);
	    	left.add(bu3);
	    	left.add(sf);
	    	left.add(js);
	    	left.setLayout(new GridLayout(6, 2));
	    	left.setBounds((screenW/2)-650, (screenH/2)-400, 300, 600);
	    	left.setVisible(true);
	    	bu.addActionListener(new ActionListener() {				//����ѡ���ļ���ť
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					qidong();
				}
			});
	    	bu2.addActionListener(new ActionListener() {			//���»��ư�ť
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					if(dq!="") {
						grayyuzhi = Integer.parseInt(hd.getText());
						yuzhi = Integer.parseInt(yuz.getText());
						if(jr1.isSelected()) {
							System.out.println("1");
						}else if(jr2.isSelected()){
							System.out.println("2");
						}else if(jr3.isSelected()) {
							System.out.println("3");
						}
						start();
					}else {
						Frame nothing = new JFrame("����");
						JLabel ts = new JLabel("δѡ��ͼƬ������ѡ��......");
						ts.setFont(new Font("����", Font.BOLD, 25));
						nothing.add(ts);
						nothing.setBounds((screenW/2)-200, (screenH/2)-50, 400, 100);
						nothing.setVisible(true);
					}
					
				}
			});
	    	js.addChangeListener(new ChangeListener() {				//�ı�����
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO �Զ����ɵķ������
					if(hz) {
						gengx();
					}
				}
			});
	    	bu3.addActionListener(new ActionListener() {			//���±��水ť
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					if(hz) {//�Ƿ��Ѿ�����
						JFileChooser JFC = new JFileChooser();
						JFC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						if( JFC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {       //˵��ѡ����һ���ļ�
							File t = JFC.getSelectedFile();
							bc = t.getPath();
							Date date = new Date();
							SimpleDateFormat dateformate = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
							String name = dateformate.format(date);
							bc = bc+"\\"+name+".png";
							System.out.println(bc);
							//setVisible(false);
							try {
								baocun();
							} catch (IOException e1) {//�������
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
								Frame nothing = new JFrame("����");
								JLabel ts = new JLabel("�ļ�����ͻ������ԭ�����Ժ�����");
								ts.setFont(new Font("����", Font.BOLD, 25));
								nothing.add(ts);
								nothing.setBounds((screenW/2)-250, (screenH/2)-50, 500, 100);
								nothing.setVisible(true);
							}
							Frame ok = new JFrame("�ɹ�");
							JLabel ts = new JLabel("�ɹ����棬�ļ���:"+name+".png");
							ts.setFont(new Font("����", Font.BOLD, 25));
							ok.add(ts);
							ok.setBounds((screenW/2)-300, (screenH/2)-50, 600, 100);
							ok.setVisible(true);
						}
					}else {
						Frame nothing = new JFrame("����");
						JLabel ts = new JLabel("δ����ͼƬ�����Ȼ���......");
						ts.setFont(new Font("����", Font.BOLD, 25));
						nothing.add(ts);
						nothing.setBounds((screenW/2)-200, (screenH/2)-50, 400, 100);
						nothing.setVisible(true);
					}
				}
			});
	    	
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setVisible(true);
	    	
	    	
	    }
	    
	    public void baocun() throws IOException {
	    	FileOutputStream output = new FileOutputStream(bc); //����ļ�
			ImageIO.write(bi, "PNG", output);							
			output.close();
	    }
	    
	    public void gengx() {
	    	//setVisible(false);
	    	remove(tu);
	    	pack();
	    	bi2 = new BufferedImage( bi.getWidth()*js.getValue()/100, bi.getHeight()*js.getValue()/100, bi.getType());
			Graphics2D g = (Graphics2D) bi2.getGraphics();
			g.drawImage(bi, 0, 0, bi2.getWidth(), bi2.getHeight(), null);
			tu = new JLabel(new ImageIcon(bi2));
			add(tu);
			pack();
			g.dispose();
			//setVisible(true);
			System.out.println("�ı�ɹ���");
	    }
	    
	    public void qidong() {
	    	JFileChooser jfchooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("png,jpg","jpg","png");
		    jfchooser.setFileFilter(filter);
		    jfchooser.setMultiSelectionEnabled(false);
		    int option = jfchooser.showOpenDialog(null);
			if( option == JFileChooser.APPROVE_OPTION) {       //˵��ѡ����һ���ļ�
				File t = jfchooser.getSelectedFile();
				dq = t.getPath();
				System.out.println(dq);
			}
	    }
			
	    public int getrgbhe(int x, int y) {
	    	Color color = new Color(bufferedImage.getRGB(x, y));
			int d=0,e=0,f=0;
			d = color.getRed();
			e = color.getGreen();
			f = color.getBlue();
			return ((d+e+f)/3);
	    }
		public int get(int x,int y){//��ȡRGB��ֵ
			//System.out.println("h:"+h+" w:"+w);
			Color color = new Color(bufferedImage.getRGB(x, y));
			int d=0,e=0,f=0;
			d = color.getRed();
			e = color.getGreen();
			f = color.getBlue();
			int dx=0,ex=0,fx=0;
			int dy=0,ey=0,fy=0;
			int dxy=0,exy=0,fxy=0;
			//System.out.println("x,y "+x+","+y);
			//System.out.println("r,g,b "+d+" "+e+" "+f+" ");
			if((x+1)<w) {
				Color colorx = new Color(bufferedImage.getRGB(x+1, y));
				dx = colorx.getRed();
				ex = colorx.getGreen();
				fx = colorx.getBlue();
			}else {
				dx = d;ex = e;fx = f;
			}
			if((y+1)<h) {
				Color colory = new Color(bufferedImage.getRGB(x, y+1));
				dy = colory.getRed();
				ey = colory.getGreen();
				fy = colory.getBlue();
			}else {
				dy = d;ey = e;fy = f;
			}
			if((x+1)<w&(y+1)<h) {
				Color colorxy = new Color(bufferedImage.getRGB(x+1, y+1));
				dxy = colorxy.getRed();
				exy = colorxy.getGreen();
				fxy = colorxy.getBlue();
			}else {
				dxy = d;exy = e;fxy = f;
			}
			//System.out.println("r2,g2,b2 "+d2+" "+e2+" "+f2+" ");
			return ((((dx-d)*(dx-d))+((ex-e)*(ex-e))+((fx-f)*(fx-f))
					+((dy-d)*(dy-d))+((ey-e)*(ey-e))+((fy-f)*(fy-f))
					+((dxy-d)*(dxy-d))+((exy-e)*(exy-e))+((fxy-f)*(fxy-f)))/9);
		}
		public void bijiao() {//�Ƚ���ֵ������
			remove(tu);
			pack();
			get(0,0);
			bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = (Graphics2D) bi.getGraphics();
			g2.setColor(Color.WHITE);//������ɫ
			g2.fillRect(0, 0, w, h);
			g2.setColor(Color.BLACK);
			//��ʼ��
			for(int ih=0;ih<h;ih++) {
				for(int iw=0;iw<w;iw++) {
					//System.out.println("     "+get(iw,ih));
					if(get(iw,ih)>(yuzhi*yuzhi)) {
						if(jr1.isSelected()) {//�Ƿ����Ҷ�ģʽ
							g2.setColor(Color.BLACK);
						}else {
							int red=0,
								green=0,
								blue=0;
							if(getrgbhe(iw,ih)>=grayyuzhi&jr2.isSelected()) {//�Ҷ�ģʽ1��ԭͼ�Ҷ� 
								red = green = blue = getrgbhe(iw,ih)-grayyuzhi;
							}else if(Graymode==1){
								red = green = blue = grayyuzhi-getrgbhe(iw,ih);
							}else if(((get(iw,ih)-grayyuzhi*grayyuzhi))>=0&jr3.isSelected()) {//�Ҷ�ģʽ2���ԱȻҶ� 
								red = green = blue = 255-(get(iw,ih)-grayyuzhi*grayyuzhi)/255;
							}else if(Graymode==2){
								red = green = blue = 255+(get(iw,ih)-grayyuzhi*grayyuzhi)/255;
							}
							//System.out.println("p="+(get(iw,ih)-grayyuzhi*grayyuzhi)+"  "+red);
							
							if(red>255) {
								red = 255;
								blue = 255;
								green = 255;
							}else if(red<0) {
								red = 0;
								blue = 0;
								green = 0;
							}
							//System.out.println("red="+red);;
							Color col = new Color(red, green, blue);
							g2.setColor(col);
						}
						g2.drawLine(iw, ih, iw, ih);
					}
				}
				System.out.println("���������"+(ih+1)+"  ��ʣ��"+(h-ih-1));
			}
			//bi2Ҫ�������ţ�biΪԭʼͼ��
			//FileOutputStream output = new FileOutputStream(bc); //����ļ�
			//ImageIO.write(bi, "PNG", output);
			//output.close();
			//setVisible(false);
			/**Graphics2D g3 = (Graphics2D)g2;
			Image img;
			URL imgurl=CanvasPanel.class.getResource(".\\pant.jpg");
			img = Toolkit.getDefaultToolkit().getImage(imgurl);
			g3.drawImage(img, 500, 500, this);**/
			bi2 = new BufferedImage( bi.getWidth()*js.getValue()/100, bi.getHeight()*js.getValue()/100, bi.getType());
			Graphics2D g = (Graphics2D) bi2.getGraphics();
			g.drawImage(bi, 0, 0, bi2.getWidth(), bi2.getHeight(), null);
			tu = new JLabel(new ImageIcon(bi2));
			add(tu);
			pack();
			
			//setVisible(true);
			System.out.println("���ɳɹ�");
			g.dispose();
			g2.dispose();
			hz = true;
		}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new MAIN();
	}

}
	class CanvasPanel extends Canvas{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void pant(Graphics g) {
			this.setSize(500, 500);
			
		}
	}
