package MainPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergey
 */
public class UI_Grid extends UI_Base {
    
    private final int CONTROLS_HEIGHT = 500;
    private final int CONTROLS_WIDTH = 250;
    private final int HEADER_HEGIHT = 30;

    private World world;
    int cellSize = 40;
    int worldSize;
    int flyCount;
    int spiderCount;   
     
    private int stepCount;
   
         public UI_Grid(int worldSize, int flyCount, int spiderCount)  {
         super(Configs.getBGPath());
         initComponents();

         initGrid(worldSize, flyCount, spiderCount); 
       }
       
       
     
    public UI_Grid()  {  
        this(15, 5, 4); //default form
    }
    
    private void initGrid(int wSize, int countFly, int countSpider)
    {
         // make sure the opacity is false on the panels
        pnlWorld.setOpaque(false);
        pnlContainer.setOpaque(false);
         
       setValues(wSize,  countFly,  countSpider); // set the form attributes and the values in spinner
       
       
       pnlWorld.setLayout(new GridLayout(worldSize,worldSize)); //initialize the grid layout on the world panel
       
       setFrameSize(); //dynamically calculate the size of the from and other panels based on the screen resolution of the user screen.

       setResizable(false);
        
        //put random flies and spiders
        world.setRandomOrganisms("fly", flyCount);
        world.setRandomOrganisms("spider", spiderCount);
        displayWordInGrid(); // display the world
       
        lblLoader.setVisible(false);

        repaint(); //repaint the form.
    }
    
     /***
     * Set frame size based on the screen resolution of the user
     */
    private void setFrameSize(){
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
    
        if (screenHeight > screenWidth)
            screenHeight = screenWidth; //just in the case screen height is greater thatn screen width then make height equeal to width
                                        // this makes sure the smallest dimension is used as the base.

        //determine the size of the world grid, which then will determine the size of the form
        int worldDimension = (int)Math.min(screenHeight - HEADER_HEGIHT, screenWidth - CONTROLS_WIDTH);
        worldDimension = worldDimension - 100; //allow 100 pixels for border, other frame paddings, and other user operating system things show on the screen
   
        pnlWorld.setSize(worldDimension, worldDimension);
        
        int formHeight = worldDimension + HEADER_HEGIHT; 
        int formWidth = worldDimension + CONTROLS_WIDTH;
        

        this.initSettings(Configs.getBGPath(),formWidth, formHeight);
         
        pnlHeader.setSize(HEADER_HEGIHT,formWidth);
        lblHeader.setSize(HEADER_HEGIHT,formWidth);
       
       pnlContainer.setSize(formWidth, formHeight);
       
       
       pnlControls.setSize(CONTROLS_WIDTH, CONTROLS_HEIGHT); //default size of the control panel
       pnlSouth.setSize(0,0);
       pnlWest.setSize(0,0);
     
       this.cellSize = worldDimension/worldSize; //calculate dynamic size of the sell
        
    }
    private void setValues(int wSize, int countFly, int countSpider)
    {
        
        this.worldSize = wSize;
        this.flyCount = countFly;
        this.spiderCount = countSpider;
        this. world = new World(worldSize);
        
        spinFlyCount.setValue(flyCount);
        spinSpiderCount.setValue(spiderCount);
        spinWorldSize.setValue(worldSize);
    }
    private int getFrameHeight(){
        
         int frameHeight = pnlContainer.getHeight();
       
        if (frameHeight < 450*1.0)
            frameHeight  = 600; //make sure it is at least 600
        
        return frameHeight;
    }
    
    private void displayWordInGrid( )
    {
        pnlWorld.removeAll();
        //revalidate();
        //repaint();
        
        int flyCount = 0;
        int spiderCount = 0;
        int emptyCount = 0;
        
        //Display world in th grid
        for (int r = 0; r < world.getSize(); r++)
        {
            for (int c = 0; c < world.getSize(); c++)
            {
                Organism org = world.getAt(r,c);
                if (org ==null)
                    emptyCount++;
                else
                {
                    if (org instanceof Spider)
                        spiderCount++;
                     if (org instanceof Fly)
                           flyCount++;
                } 
                
                Cell cell = new Cell(cellSize, r, c,org);
               pnlWorld.add(cell);
                
            }
        }
        
        lblFlyCount.setText("Fly count: " + flyCount);
        lblSpiderCount.setText("Spider count: " + spiderCount);
        lblEmptyCount.setText("Empty space count: " + emptyCount);
        lblStepCount.setText("Steps Completed: " + stepCount); 
        revalidate();
        repaint();
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        pnlControls = new javax.swing.JPanel();
        btnStep = new javax.swing.JButton();
        txtStepNum = new javax.swing.JTextField();
        lblLoader = new javax.swing.JLabel();
        pnlCounter = new javax.swing.JPanel();
        lblFlyCount = new javax.swing.JLabel();
        lblSpiderCount = new javax.swing.JLabel();
        lblEmptyCount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblStepCount = new javax.swing.JLabel();
        pnlInit = new javax.swing.JPanel();
        lblInitHeader = new javax.swing.JLabel();
        lblInitSpiderCount = new javax.swing.JLabel();
        lblInitFlyCount = new javax.swing.JLabel();
        lblIniti = new javax.swing.JButton();
        lblWorldSize = new javax.swing.JLabel();
        spinFlyCount = new javax.swing.JSpinner();
        spinSpiderCount = new javax.swing.JSpinner();
        spinWorldSize = new javax.swing.JSpinner();
        pnlHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        pnlWorld = new javax.swing.JPanel();
        pnlWest = new javax.swing.JPanel();
        pnlSouth = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlContainer.setLayout(new java.awt.BorderLayout(5, 5));

        pnlControls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnStep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStep.setText("Step");
        btnStep.setMaximumSize(new java.awt.Dimension(62, 50));
        btnStep.setMinimumSize(new java.awt.Dimension(62, 50));
        btnStep.setPreferredSize(new java.awt.Dimension(62, 50));
        btnStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnStepMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnStepMouseReleased(evt);
            }
        });
        btnStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStepActionPerformed(evt);
            }
        });

        txtStepNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtStepNum.setForeground(new java.awt.Color(0, 0, 153));
        txtStepNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStepNum.setText("1");

        lblLoader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load.gif"))); // NOI18N

        lblFlyCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFlyCount.setForeground(new java.awt.Color(51, 153, 0));
        lblFlyCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFlyCount.setText("Fly Count:");

        lblSpiderCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSpiderCount.setForeground(new java.awt.Color(153, 0, 51));
        lblSpiderCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSpiderCount.setText("Spider Count:");

        lblEmptyCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmptyCount.setForeground(new java.awt.Color(0, 102, 204));
        lblEmptyCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmptyCount.setText("Empty Count:");

        lblStepCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStepCount.setForeground(new java.awt.Color(102, 102, 0));
        lblStepCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStepCount.setText("Step Count:");

        javax.swing.GroupLayout pnlCounterLayout = new javax.swing.GroupLayout(pnlCounter);
        pnlCounter.setLayout(pnlCounterLayout);
        pnlCounterLayout.setHorizontalGroup(
            pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCounterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCounterLayout.createSequentialGroup()
                        .addComponent(lblFlyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSpiderCount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCounterLayout.createSequentialGroup()
                        .addComponent(lblStepCount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmptyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCounterLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jSeparator1)
                    .addGap(23, 23, 23)))
        );
        pnlCounterLayout.setVerticalGroup(
            pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCounterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStepCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFlyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpiderCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
            .addGroup(pnlCounterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCounterLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pnlInit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInitHeader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInitHeader.setLabelFor(this);
        lblInitHeader.setText("Initial Values");

        lblInitSpiderCount.setText("Spider Count:");

        lblInitFlyCount.setText("Fly Count:");

        lblIniti.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIniti.setText("Initialize");
        lblIniti.setMaximumSize(new java.awt.Dimension(62, 50));
        lblIniti.setMinimumSize(new java.awt.Dimension(62, 50));
        lblIniti.setPreferredSize(new java.awt.Dimension(62, 50));
        lblIniti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInitiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblInitiMouseReleased(evt);
            }
        });

        lblWorldSize.setText("World Size:");

        javax.swing.GroupLayout pnlInitLayout = new javax.swing.GroupLayout(pnlInit);
        pnlInit.setLayout(pnlInitLayout);
        pnlInitLayout.setHorizontalGroup(
            pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInitHeader)
                .addGap(105, 105, 105))
            .addGroup(pnlInitLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblWorldSize)
                    .addComponent(lblInitFlyCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinFlyCount, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(spinWorldSize))
                .addGroup(pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInitLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIniti, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblInitSpiderCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinSpiderCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInitLayout.setVerticalGroup(
            pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInitHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInitFlyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInitSpiderCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinFlyCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinSpiderCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWorldSize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIniti, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinWorldSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlControlsLayout = new javax.swing.GroupLayout(pnlControls);
        pnlControls.setLayout(pnlControlsLayout);
        pnlControlsLayout.setHorizontalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlControlsLayout.createSequentialGroup()
                        .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlControlsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtStepNum, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnStep, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLoader))
                            .addGroup(pnlControlsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(pnlCounter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlControlsLayout.setVerticalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStepNum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pnlContainer.add(pnlControls, java.awt.BorderLayout.EAST);

        pnlHeader.setPreferredSize(new java.awt.Dimension(670, 50));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(102, 153, 0));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Predator–Prey simulation");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pnlContainer.add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlWorld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlWorldLayout = new javax.swing.GroupLayout(pnlWorld);
        pnlWorld.setLayout(pnlWorldLayout);
        pnlWorldLayout.setHorizontalGroup(
            pnlWorldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        pnlWorldLayout.setVerticalGroup(
            pnlWorldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );

        pnlContainer.add(pnlWorld, java.awt.BorderLayout.CENTER);

        pnlWest.setMaximumSize(new java.awt.Dimension(20, 32767));
        pnlWest.setMinimumSize(new java.awt.Dimension(20, 100));
        pnlWest.setPreferredSize(new java.awt.Dimension(20, 465));

        javax.swing.GroupLayout pnlWestLayout = new javax.swing.GroupLayout(pnlWest);
        pnlWest.setLayout(pnlWestLayout);
        pnlWestLayout.setHorizontalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        pnlWestLayout.setVerticalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
        );

        pnlContainer.add(pnlWest, java.awt.BorderLayout.WEST);

        pnlSouth.setMaximumSize(new java.awt.Dimension(20, 32767));
        pnlSouth.setMinimumSize(new java.awt.Dimension(20, 100));
        pnlSouth.setPreferredSize(new java.awt.Dimension(20, 100));

        javax.swing.GroupLayout pnlSouthLayout = new javax.swing.GroupLayout(pnlSouth);
        pnlSouth.setLayout(pnlSouthLayout);
        pnlSouthLayout.setHorizontalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        pnlSouthLayout.setVerticalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlContainer.add(pnlSouth, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlContainer);
        pnlContainer.setBounds(0, 0, 850, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInitiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInitiMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblInitiMouseReleased

    private void lblInitiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInitiMousePressed
        int flyCount = Integer.parseInt(spinFlyCount.getValue().toString());
        int spiderCount = Integer.parseInt(spinSpiderCount.getValue().toString());
        int wordlSize = Integer.parseInt(spinWorldSize.getValue().toString());
        
        UI_Grid newForm = new UI_Grid(wordlSize, flyCount, spiderCount);
        newForm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_lblInitiMousePressed

    private void btnStepMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStepMouseReleased

    }//GEN-LAST:event_btnStepMouseReleased

    private void btnStepMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStepMousePressed
        
         if (lblLoader.isVisible()==true)
            return;
          
         int stepsToExecute = Integer.parseInt(txtStepNum.getText());
           
         new Thread(() -> {
             lblLoader.setVisible(true);
               for (int i=0; i < stepsToExecute; i++)
                    world.SimulateOneStep();
             
             displayWordInGrid();
             lblLoader.setVisible(false);  
        }).start();
         
        stepCount+=stepsToExecute;
        
        /*
        progress = new ProgressInfinite(stepsToExecute);
        progress.execute();
        
       */    
      

    }//GEN-LAST:event_btnStepMousePressed

    private void btnStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStepActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStep;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmptyCount;
    private javax.swing.JLabel lblFlyCount;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInitFlyCount;
    private javax.swing.JLabel lblInitHeader;
    private javax.swing.JLabel lblInitSpiderCount;
    private javax.swing.JButton lblIniti;
    private javax.swing.JLabel lblLoader;
    private javax.swing.JLabel lblSpiderCount;
    private javax.swing.JLabel lblStepCount;
    private javax.swing.JLabel lblWorldSize;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlControls;
    private javax.swing.JPanel pnlCounter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlInit;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JPanel pnlWorld;
    private javax.swing.JSpinner spinFlyCount;
    private javax.swing.JSpinner spinSpiderCount;
    private javax.swing.JSpinner spinWorldSize;
    private javax.swing.JTextField txtStepNum;
    // End of variables declaration//GEN-END:variables
}
