package logic;

import java.util.List;
import java.util.Vector;

import dao.GradeCheckDao;
import dto.GradeProVO;
import dto.ProfessorVO;
import view_pro.GradeCheckPro;
import view_pro.Inputgrade;
import view_pro.MainFormPro;
import view_pro.ClassPro;
import dao.GradeCheckDao;

import dao.ClassDao;
import dto.LectureVO;
import view_st.ClassAddStudent;

public class ClassAddStudentLogic {

  ClassAddStudent cas = null;
  ClassDao cd = null;
  ClassPro classpro = null;
  String[] leclist = null;

  GradeCheckDao gcd = null;

  public ClassAddStudentLogic() {

  }

  public ClassAddStudentLogic(ClassAddStudent cas) {
    this.cas = cas;
  }

  public void getTotalLectureList(String lecture) {
    cd = new ClassDao();
    List<LectureVO> gradelist = cd.getLecture2(lecture);

    // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
    while (classpro.dtm_grade.getRowCount() > 0) {
      classpro.dtm_grade.removeRow(0);
    }

    // 가져온 데이터를 vector에 담아 한줄씩 넣어준다
    for (int i = 0; i < gradelist.size(); i++) {
      Vector<String> result = new Vector<>();
      LectureVO gpvo = new LectureVO();
      gpvo = gradelist.get(i);
      result.add(gpvo.getLecture());
      result.add(gpvo.getProfessor());
      result.add(gpvo.getLectime());
      // classpro.dtm_grade.addRow(result);
      System.out.println("gpvo ::::: " + gpvo);
      System.out.println(result);
    }
  }

  public String[] getLectureList() {
    gcd = new GradeCheckDao();
    List<String> lectureList = gcd.getLectureList();
    leclist = new String[lectureList.size()];

    for (int i = 0; i < leclist.length; i++) {
      leclist[i] = lectureList.get(i);

    }

    return leclist;
  }
}