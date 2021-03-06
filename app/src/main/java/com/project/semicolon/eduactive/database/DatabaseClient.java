package com.project.semicolon.eduactive.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.database.daos.CoursesDao;
import com.project.semicolon.eduactive.database.daos.DepartmentDao;
import com.project.semicolon.eduactive.database.daos.EmployeesDao;
import com.project.semicolon.eduactive.database.daos.EventDao;
import com.project.semicolon.eduactive.database.daos.ExamsBankDao;
import com.project.semicolon.eduactive.database.daos.InstructorDao;
import com.project.semicolon.eduactive.database.daos.LabsDao;
import com.project.semicolon.eduactive.database.daos.NewsDao;
import com.project.semicolon.eduactive.database.daos.StudentCoursesDao;
import com.project.semicolon.eduactive.database.daos.StudentDao;
import com.project.semicolon.eduactive.database.entities.CoursesEntity;
import com.project.semicolon.eduactive.database.entities.DepartmentEntity;
import com.project.semicolon.eduactive.database.entities.EmployeesEntity;
import com.project.semicolon.eduactive.database.entities.EventEntity;
import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.database.entities.InstructorsEntity;
import com.project.semicolon.eduactive.database.entities.LabsEntity;
import com.project.semicolon.eduactive.database.entities.NewsEntity;
import com.project.semicolon.eduactive.database.entities.ReportsEntity;
import com.project.semicolon.eduactive.database.entities.StudentCoursesEntity;
import com.project.semicolon.eduactive.database.entities.StudentEntity;
import com.project.semicolon.eduactive.utils.AppExactors;

import java.util.ArrayList;
import java.util.List;


@Database(entities = {
        CoursesEntity.class,
        DepartmentEntity.class,
        EmployeesEntity.class,
        ExamsBankEntity.class,
        InstructorsEntity.class,
        LabsEntity.class,
        NewsEntity.class,
        ReportsEntity.class,
        StudentCoursesEntity.class,
        EventEntity.class,
        StudentEntity.class},
        version = 1)
@TypeConverters(DateConverter.class)
public abstract class DatabaseClient extends RoomDatabase {
    private static final String TAG = "DatabaseClient";
    private static final String DB_NAME = "graduation_project.db";
    private static volatile DatabaseClient instance;

    public abstract StudentDao getStudentDao();

    public abstract NewsDao getNewsDao();

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = createDatabase(context);
        }

        return instance;
    }

    private static DatabaseClient createDatabase(final Context context) {
        return Room.databaseBuilder(
                context,
                DatabaseClient.class, DB_NAME).
                addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        initialData(context);
                    }
                }).build();
    }

    private static void initialData(final Context context) {
        AppExactors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<StudentEntity> studentList = new ArrayList<>();
                studentList.add(new StudentEntity("800114265", "Hassan Salah", "drty257*",
                        "Mansoura", "Dakhlya", "hassan.s.mohammed1997@gmail"));
                studentList.add(new StudentEntity("800114355", "Khalid Ezzat",
                        "1234@", "Mansoura", "Dakhlya", "kahlid@hmail.com"));

                List<NewsEntity> articleList = new ArrayList<>();
                articleList.add(new NewsEntity("odio. Nam interdum enim non nisi. Aenean eget metus. In",
                        "Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque",
                        R.drawable.article_1, (byte) 1));
                articleList.add(new NewsEntity("in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est",
                        "convallis dolor. Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed,\n",
                        R.drawable.article_2, (byte) 2));
                articleList.add(new NewsEntity("blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus",
                        "scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis",
                        R.drawable.article_3, (byte) 0));

                List<ExamsBankEntity> exams = new ArrayList<>();
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/4/27/235aeilotzc81e728d9d4c2f636f067f89cc14862c.pdf",
                        "", false, "2015",
                        "Dr. Sherif Shata", (byte) 1, (byte) 0, "Technical Writing"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/4/27/235aeilotzc81e728d9d4c2f636f067f89cc14862c.pdf",
                        "", false, "2016", "Dr. Mahmoud Saafan", (byte) 1, (byte) 3, "Computer Application"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/3/27/27bfikorxyd04eef0bbb4b80a806f7e5b69e371187.pdf",
                        "", false, "2016", "Dr. Merfat Abo Elkhair", (byte) 1, (byte) 0, "Physics 2"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/3/27/137aciqrwz23bac77e481ca362f8ffc9e73b5b6ba8.pdf",
                        "", false, "2016", "Dr. Rada Abdo", (byte) 1, (byte) 0, "Mathematics 2"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/4/25/35780adswz7864ebd9f164a802fee003d715b159db.pdf",
                        "", false, "2013", "Dr. Ahmed Saled", (byte) 1, (byte) 1, "Computer Programming"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/4/25/279bgijmoqe0e1d64fdac4188f087c4d44060de65e.pdf",
                        "", false, "2014", "Dr. Sabry Saraya", (byte) 1, (byte) 1, "Digital Design 2"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/5/25/1346defmux631ac552bb5c268e5420a3308130aca1.pdf",
                        "", false, "2014", "Dr. Amr Thabet", (byte) 1, (byte) 2, "Programming II"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/5/24/50noptuvyzb652d6d8c3db3126b0f59c7c59123ccf.pdf",
                        "", false, "2013", "Dr. Fayez Areed", (byte) 1, (byte) 2, "Digital Control Systems"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/5/24/50noptuvyzb652d6d8c3db3126b0f59c7c59123ccf.pdf",
                        "", false, "2014", "Dr. Aly El Desokey", (byte) 1, (byte) 3, "Data Structure"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/6/25/56cegmnqsz2ba20be55adf8e2f7f0d6c61515ab25a.pdf",
                        "", false, "2013", "Dr. Ahmed Saled", (byte) 1, (byte) 3, "Computer Architecture"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/6/25/56cegmnqsz2ba20be55adf8e2f7f0d6c61515ab25a.pdf",
                        "", false, "2013", "Dr. Hesham Arafat", (byte) 1, (byte) 4, "Data Processing I"));
                exams.add(new ExamsBankEntity("http://exams.mans.edu.eg/uploads/17/7/24/14efjkrstzf58c71f8ade0320915fd496b57e56879.pdf",
                        "", false, "2013", "Dr. Abdelhameed Fawzy", (byte) 1, (byte) 4, "Machine Learning"));

                List<InstructorsEntity> instuctors = new ArrayList<>();
                instuctors.add(new InstructorsEntity("Mahmoud", "Saafan", "1234", "Professor", "+2010123456", "800113245", "12345", "Cairo", "Egypt", "dr.saafan@email.com"));
                instuctors.add(new InstructorsEntity("Mahmoud", "Saafan", "1234", "Professor", "+2010123456", "800113245", "12345", "Cairo", "Egypt", "dr.saafan@email.com"));
                instuctors.add(new InstructorsEntity("Mahmoud", "Saafan", "1234", "Professor", "+2010123456", "800113245", "12345", "Cairo", "Egypt", "dr.saafan@email.com"));
                instuctors.add(new InstructorsEntity("Mahmoud", "Saafan", "1234", "Professor", "+2010123456", "800113245", "12345", "Cairo", "Egypt", "dr.saafan@email.com"));


                List<CoursesEntity> courses = new ArrayList<>();
                courses.add(new CoursesEntity("HCI", "Code 1", 3, "", "", "", 50, 1));
                courses.add(new CoursesEntity("Logic 2", "Code 2", 3, "", "", "", 50, 2));
                courses.add(new CoursesEntity("Computer Arch", "Code 3", 3, "", "", "", 50, 4));
                courses.add(new CoursesEntity("English 2", "Code 4", 2, "", "", "", 50, 1));

                List<StudentCoursesEntity> studentCourses = new ArrayList<>();
                studentCourses.add(new StudentCoursesEntity(1, 2));
                studentCourses.add(new StudentCoursesEntity(1, 3));
                studentCourses.add(new StudentCoursesEntity(1, 1));
                studentCourses.add(new StudentCoursesEntity(2, 2));
                studentCourses.add(new StudentCoursesEntity(2, 1));
                studentCourses.add(new StudentCoursesEntity(2, 3));

                List<EventEntity> events = new ArrayList<>();
                events.add(new EventEntity("Art Institute of Chicago", context.getString(R.string.long_lorem_ipsum_2),
                        1587180015,
                        "111 S Michigan Avec",
                        30, 10,
                        "https://images.unsplash.com/photo-1531001142232-7d7aac16a63e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=300&q=60",
                        "3"));


                events.add(new EventEntity("A 4-day trip to Alexandria", context.getString(R.string.very_long_lorem_ipsum),
                        158197984,
                        "Alexandria",
                        30, 30,
                        "https://images.unsplash.com/photo-1559357711-e442ab604fdc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=333&q=80",
                        "4"));

                events.add(new EventEntity("Graduation Party", context.getString(R.string.very_long_lorem_ipsum),
                        1606592160,
                        "Mansoura university",
                        100, 50,
                        "https://images.unsplash.com/photo-1533854775446-95c4609da544?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80",
                        "1"));

                getInstance(context)
                        .instructorDao().insert(instuctors);

                getInstance(context)
                        .getExamsDao().insert(exams);

                getInstance(context)
                        .getStudentDao().insertStudentList(studentList);

                getInstance(context)
                        .getNewsDao().insertArticleList(articleList);

                getInstance(context)
                        .coursesDao().insert(courses);

                getInstance(context)
                        .studentCoursesDao().insert(studentCourses);

                getInstance(context)
                        .eventDao().insert(events);


            }
        });


    }

    public abstract DepartmentDao getDepartmentDao();

    public abstract EmployeesDao employesDao();

    public abstract InstructorDao instructorDao();

    public abstract CoursesDao coursesDao();

    public abstract ExamsBankDao getExamsDao();

    public abstract StudentCoursesDao studentCoursesDao();

    public abstract LabsDao labsDao();

    public abstract EventDao eventDao();


}