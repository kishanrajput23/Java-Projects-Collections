abstract class Host {

  // call subject selector
   void subject() {
    subject_selector.select_subjet();
  }

  // call Question_setter
  boolean questions() {
    return question_setter.set_questions();
  }

  // call Set_time `

  public void time(int wait) {
    Set_time.set(wait);
  }

}
