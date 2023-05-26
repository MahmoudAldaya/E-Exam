package marah.e.exam;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import javafx.scene.layout.Pane;


public class Utils {
    public static ArrayList <Users> users = new ArrayList<>();
    public static ArrayList <Question> questions = new ArrayList<>();
    public static ArrayList <Exams> exams = new ArrayList<>();
    public static ArrayList <SolvedExams> solvedExams = new ArrayList<>();

    public static void fillTheData(){
        users.add(new Users());

        users.add(new Users("JafarAgha", "112233", "1/1/1997", "Jafar Al-Agha", "male", 2000, "Eng")); //tec String username, String password, String birthday, String name, String gender, double salary, String specialty
        users.add(new Users("MohDalo", "112233", "1/1/1998", "Mohammed Al-Dalo", "male", 1000, "Eng")); //teacher
        users.add(new Users("EtafHadda", "112233", "1/1/1999", "Etaf Abo Hadda", "female", 3000, "Eng")); //teacher
        users.add(new Users("HashemSaqqa", "112233", "5/11/2000", "Hashem Al-Saqqa", "male", 1500, "IT")); //teacher
        users.add(new Users("m", "m", "5/11/2000", "Hashem Al-Saqqa", "male", 1500, "IT")); //teacher


        questions.add(new Question("q1", "Does JDK stands for 'java development kit' ", 3, "TF", "yes"));
        questions.add(new Question("q2", "Is Java a statically typed language?", 4, "TF", "no"));
        questions.add(new Question("q3", "Are Java interfaces implemented using the 'implements' keyword?", 5, "TF", "yes"));
        questions.add(new Question("q4", "Java applications can be run on any platform that has the Java Virtual Machine installed?", 3, "TF", "yes"));
        questions.add(new Question("q5", "Java supports multiple inheritance?", 2, "TF", "no"));
        questions.add(new Question("q6", "Java is an object-oriented programming language?", 4, "TF", "yes"));
        questions.add(new Question("q7", "Java programs are compiled into machine language?", 3, "TF", "no"));
        questions.add(new Question("q8", "Java arrays have a fixed length?", 2, "TF", "yes"));
        questions.add(new Question("q9", "Java has a garbage collector to automatically manage memory?", 4, "TF", "yes"));
        questions.add(new Question("q10", "Java has a built-in support for creating GUI applications?", 5, "TF", "yes"));
        questions.add(new Question("q11", "Java code is compiled into bytecode?", 3, "TF", "yes"));
        questions.add(new Question("q12", "Java variables must be declared with a data type?", 2, "TF", "yes"));
        questions.add(new Question("q13", "Java methods can be overloaded?", 4, "TF", "yes"));
        questions.add(new Question("q14", "Java supports operator overloading?", 3, "TF", "no"));
        questions.add(new Question("q15", "Java has a built-in support for regular expressions?", 5, "TF", "yes"));
        questions.add(new Question("q16", "Java has a built-in support for multi-threading?", 4, "TF", "yes"));
        questions.add(new Question("q17", "Java has a built-in support for networking?", 5, "TF", "yes"));
        questions.add(new Question("q18", "Java programs can be run on any platform that has a Java compiler installed?", 3, "TF", "no"));
        questions.add(new Question("q19", "Java supports pass-by-reference for method parameters?", 2, "TF", "no"));
        questions.add(new Question("q20", "Java supports operator overloading?", 3, "TF", "no"));


        questions.add(new Question("q21", "The capital of France is ___", 5, "FB", "Paris"));
        questions.add(new Question("q22", "The world's highest mountain is ___", 5, "FB", "Mount Everest"));
        questions.add(new Question("q23", "The largest ocean in the world is ___", 5, "FB", "Pacific Ocean"));
        questions.add(new Question("q24", "The chemical symbol for gold is ___", 5, "FB", "Au"));
        questions.add(new Question("q25", "The formula for water is ___", 5, "FB", "H2O"));
        questions.add(new Question("q26", "The longest river in the world is ___", 5, "FB", "Nile"));
        questions.add(new Question("q27", "The largest country in the world by area is ___", 5, "FB", "Russia"));
        questions.add(new Question("q28", "The smallest planet in the solar system is ___", 5, "FB", "Mercury"));
        questions.add(new Question("q29", "The largest mammal in the world is ___", 5, "FB", "Blue Whale"));
        questions.add(new Question("q30", "The fastest land animal in the world is ___", 5, "FB", "Cheetah"));
        questions.add(new Question("q31", "The deepest part of the ocean is ___", 5, "FB", "Mariana Trench"));
        questions.add(new Question("q32", "The largest desert in the world is ___", 5, "FB", "Sahara"));
        questions.add(new Question("q33", "The first element in the periodic table is ___", 5, "FB", "Hydrogen"));
        questions.add(new Question("q34", "The largest planet in the solar system is ___", 5, "FB", "Jupiter"));
        questions.add(new Question("q35", "The smallest continent in the world is ___", 5, "FB", "Australia"));
        questions.add(new Question("q36", "The first man to walk on the moon is ___", 5, "FB", "Neil Armstrong"));
        questions.add(new Question("q37", "The largest bird in the world is ___", 5, "FB", "Ostrich"));
        questions.add(new Question("q38", "The fastest bird in the world is ___", 5, "FB", "Peregrine Falcon"));
        questions.add(new Question("q39", "The largest flower in the world is ___", 5, "FB", "Rafflesia"));
        questions.add(new Question("q40", "The largest snake in the world is ___", 5, "FB", "Anaconda"));


        questions.add(new Question("q41", "What does the 'E' in E-commerce stand for?", 2, "MCQ", "Electronic", "Electronic", "Economic", "Education"));
        questions.add(new Question("q42", "What is the capital of Australia?", 2, "MCQ", "Sydney", "Sydney", "Canberra", "Brisbane"));
        questions.add(new Question("q43", "What is the largest ocean in the world?", 2, "MCQ", "Pacific Ocean", "Atlantic Ocean", "Arctic Ocean", "Pacific Ocean"));
        questions.add(new Question("q44", "What is the smallest country in the world?", 2, "MCQ", "Monaco", "Vatican City", "San Marino", "Monaco"));
        questions.add(new Question("q45", "What is the name of the biggest desert in the world?", 2, "MCQ", "Sahara Desert", "Gobi Desert", "Arabian Desert", "Sahara Desert"));
        questions.add(new Question("q46", "Who wrote the novel 'Pride and Prejudice'?", 2, "MCQ", "Emily Bronte", "Emily Bronte", "Charlotte Bronte", "Virginia Woolf"));
        questions.add(new Question("q47", "Which planet is known as the 'Red Planet'?", 2, "MCQ", "Venus", "Venus", "Jupiter", "Saturn"));
        questions.add(new Question("q48", "Which country is known as the 'Land of the Rising Sun'?", 2, "MCQ", "China", "South Korea", "China", "Vietnam"));
        questions.add(new Question("q49", "What is the smallest unit of life called?", 2, "MCQ", "Cell", "Atom", "Molecule", "Cell"));
        questions.add(new Question("q50", "What is the currency used in Japan?", 2, "MCQ", "Yuan", "Yen", "Won", "Yuan"));
        questions.add(new Question("q51", "What is the name of the famous physicist who developed the theory of relativity?", 2, "MCQ", "Isaac Newton", "Stephen Hawking", "Albert Einstein", "Isaac Newton"));
        questions.add(new Question("q52", "What is the largest animal in the world?", 2, "MCQ", "Blue Whale", "Elephant", "Blue Whale", "Hippopotamus"));
        questions.add(new Question("q53", "What is the name of the highest mountain in Africa?", 2, "MCQ", "Mount Everest", "Kilimanjaro", "Mount Everest", "Mount Olympus"));
        questions.add(new Question("q54", "What is the name of the largest river in the world?", 2, "MCQ", "Amazon River", "Nile River", "Amazon River", "Mississippi River"));
        questions.add(new Question("q55", "Which two colors are on the flag of Poland?", 2, "MCQ", "Red and White", "Green and Yellow", "Red and White", "Red and Green"));
        questions.add(new Question("q56", "What is the name of the famous Roman road that connected Rome to the south of Italy?", 2, "MCQ", "Via Appia", "Via Aurelia", "Via Appia", "Via Salaria"));
        questions.add(new Question("q57", "Who is the author of the book 'To Kill a Mockingbird'?", 3, "MCQ", "Harper Lee", "Stephen King", "Harper Lee", "Mark Twain"));
        questions.add(new Question("q58", "What is the capital of Sweden?", 2, "MCQ", "Stockholm", "Copenhagen", "Oslo", "Stockholm"));
        questions.add(new Question("q59", "Which actor portrayed the character of 'Iron Man' in the Marvel Cinematic Universe movies?", 4, "MCQ", "Robert Downey Jr.", "Chris Evans", "Robert Downey Jr.", "Tom Hiddleston"));
        questions.add(new Question("q60", "Who is the founder of Microsoft Corporation?", 3, "MCQ", "Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Bill Gates"));

        ArrayList<Question> MCQ = new ArrayList<>();
        MCQ.add(questions.get(40));
        MCQ.add(questions.get(41));
        MCQ.add(questions.get(42));

        ArrayList<Question> FB = new ArrayList<>();
        FB.add(questions.get(20));
        FB.add(questions.get(21));
        FB.add(questions.get(22));

        ArrayList<Question> TF = new ArrayList<>();
        TF.add(questions.get(0));
        TF.add(questions.get(1));
        TF.add(questions.get(2));

        ArrayList<SolvedQuestions> solvedTF = new ArrayList<>();
        solvedTF.add(new SolvedQuestions(questions.get(0), "yes"));
        solvedTF.add(new SolvedQuestions(questions.get(1), "no"));
        solvedTF.add(new SolvedQuestions(questions.get(2), "yes"));

        ArrayList<SolvedQuestions> solvedMCQ = new ArrayList<>();
        solvedMCQ.add(new SolvedQuestions(questions.get(40), "Electronic"));
        solvedMCQ.add(new SolvedQuestions(questions.get(41), "Sydney"));
        solvedMCQ.add(new SolvedQuestions(questions.get(42), "Pacific Ocean"));

        ArrayList<SolvedQuestions> solvedFB = new ArrayList<>();
        solvedFB.add(new SolvedQuestions(questions.get(20), "Paris"));
        solvedFB.add(new SolvedQuestions(questions.get(21), "Mount Everest"));
        solvedFB.add(new SolvedQuestions(questions.get(22), "Pacific Ocean"));


        ArrayList<SolvedExams> arr = new ArrayList<>();


        Exams exam1 = new Exams("java1", "2020", 12, 3, 6, TF, "TF");
        Exams exam2 = new Exams("java2", "2020", 15, 3, 8, FB, "FB");
        Exams exam3 = new Exams("java3", "2020", 6, 3, 3, MCQ, "MCQ");

        SolvedExams sExam1 = new SolvedExams(exam1, 12, solvedTF, "Ahmed Ali");
        SolvedExams sExam2 = new SolvedExams(exam2, 15, solvedFB, "Heba Ahmed");
        SolvedExams sExam3 = new SolvedExams(exam3, 6, solvedMCQ, "Dalia Mohammed");


        exams.add(exam1);
        exams.add(exam2);
        exams.add(exam3);


        solvedExams.add(sExam1);
        solvedExams.add(sExam2);
        solvedExams.add(sExam3);


        arr.add(sExam1);
        arr.add(sExam2);
        arr.add(sExam3);


        Users s1 = new Users("s1", "123456", "1/1/2000", "Ahmed Ali", "120180001", "Male", arr, 20);
        Users s2 = new Users("s2", "123456", "1/1/2001", "Heba Ahmed", "120190001", "Female", arr, 30);
        Users s3 = new Users("s3", "123456", "1/11/2002", "Dalia Mohammed", "120200001", "Female", arr, 40);


        users.add(s1); //std String username, String password, String birthday, String name, int uni_id, String gender
        users.add(s2);
        users.add(s3);

    }



    public static void clear(Pane pane){
        for(Node node : pane.getChildren()){
            if (node instanceof TextField){
                TextField text = (TextField) node;
                text.setText("");
            }
        }
    }


    public static ArrayList<Users> getUserType(int usertype){ // usertype = 1
        ArrayList<Users> returnedArrayList = new ArrayList<>();

        for(Users user : users){
            if (user.getUserType() == usertype){
                returnedArrayList.add(user);
            }
        }

        return returnedArrayList;
    }

    // users --> teacher (userType = 0) , students (userType = 1), admin (userType = -1)

    public static void AddAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
