package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dto.LectureVO;
import util.MyBatisCommonFactory;
import view_pro.ClassAdd;

public class ClassAddLogic implements ActionListener {

  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  ClassAdd ca = null;
  ClassDao cd = null;
  LectureVO lvo = null;
  String lecture = null;
  String professor = null;
  String lectime = null;

  public ClassAddLogic() {

  }

  public ClassAddLogic(ClassAdd ca) {
    this.ca = ca;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object obj = e.getSource();
    if (obj == ca.jbtn_add) {
      cd = new ClassDao();
      // 선택한 데이터를 가져온다
      lecture = ca.jtf_lecture.getText();
      professor = ca.jtf_professor.getText();
      lectime = ca.jtf_lectime.getText();

      // 가져온 데이터를 dto를 통해 생성후 파라미터로 전달
      lvo = new LectureVO(lecture, professor, lectime);
      int result = cd.getinsertlecture(lvo);

      System.out.println(result);
      if (result == 1) {
        // 성공시 1을 반환하므로 성공시 아래 로직 진행
        ca.jtf_lecture.setText("");
        ca.jtf_professor.setText("");
        ca.jtf_lectime.setText("");
        JOptionPane.showMessageDialog(ca, "강의 추가 완료", "Success", 1);
      }

    } else if (obj == ca.jbtn_cancel) {
      ca.dispose();
    }
  }
}