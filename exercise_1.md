
# עבודה עם קבצים ותיקיות ב-Java

## 1. איך יוצרים תיקייה בגאווה?

ב-Java, כדי ליצור תיקייה תחילה אנו משתמשים ב-class `File` (`import java.io.File`).  
שנית, נגדיר תיקייה שברצוננו ליצור ונציין את הנתיב שבו נרצה ליצור את התיקייה עם שם המשתנה `cm` מסוג `File`.  
שלישית, נשתמש ב-`mkdir()` כדי ליצור תיקייה חדשה ונשתמש בתנאי `if` כדי לוודא שהתיקייה נוצרה.

[קישור למדריך](https://how.dev/answers/how-to-create-a-directory-using-java)

```java
import java.io.File;

public class CmdEx {

    public static void main(String[] args){

        File cm = new File("C:\\Users\\Admin\\Downloads\\myNewFolder");

        //תדפיס אם נוצרה תיקייה או לא (לא חובה, אך עוזר לבדיקה)
        if (cm.mkdir() == true) {
            System.out.println("Directory has been created successfully");
        } else {
            System.out.println("Directory cannot be created");
        }

    }

}
```

---

## 2. איך יוצרים קובץ?

ב־Java, ניתן ליצור קובץ חדש באמצעות המחלקה `File` והשיטה `createNewFile()`.  
השיטה מחזירה `true` אם הקובץ לא קיים ונוצר בהצלחה, ו־`false` אם הקובץ כבר קיים.

[קישור למדריך](https://www.geeksforgeeks.org/file-createnewfile-method-in-java-with-examples/)

```java
import java.io.*;

public class CmdEx {
    public static void main(String args[]) {

        try {
            // יצירת הקובץ
            File f = new File("C:\\Users\\Admin\\Downloads\\myNewFolder\\Text");

            // יצירת קובץ חדש אם לא קיים
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
```

---

## 3. איך בודקים אם קובץ/תיקייה קיימים?

ניתן לבדוק אם קובץ או תיקייה קיימים באמצעות השיטה `exists()` מהמחלקה `File`.

[קישור למדריך](https://www.geeksforgeeks.org/file-exists-method-in-java-with-examples/)

```java
import java.io.*;

public class CmdEx {
    public static void main(String args[]) {
        File f = new File("C:\\Users\\Admin\\Downloads\\myNewFolder\\Text");

        if (f.exists())
            System.out.println("Exists");
        else
            System.out.println("Does not Exists");
    }
}
```

---

## 4. איך מציגים את תוכן תיקייה?

הצגת כל הקבצים והתיקיות באמצעות `listFiles()` ממחלקת `File`.

[קישור למדריך](https://www.geeksforgeeks.org/how-to-list-all-files-in-a-directory-in-java/)

```java
import java.io.File;

public class CmdEx {

    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Admin\\Downloads\\myNewFolder";
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
```

---

## 5. (רשות) מה ההבדל בין File ל-Path?

1. `Path` הוא חלק מה־NIO API החדש (מ־Java 7).  
2. `File` הוא חלק מה־IO API הישן.  
3. `Path` מספק שיטות מתקדמות יותר לעבודה עם נתיבים.  
4. `Path` תומך בקישורים סמליים, בניגוד ל־`File`.  
5. `Path` עובד יחד עם מחלקות נוספות כמו `Files` ו־`FileSystems`.

[קישור למדריך](https://www.javaguides.net/2023/11/difference-between-path-and-file-in-java-nio.html)

```java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class CmdEx {
    public static void main(String[] args) {
        // שימוש ב-Path
        Path path = Paths.get("C:\\Users\\Admin\\Downloads\\myNewFolder");
        System.out.println("Path: " + path.toString());

        // שימוש ב-File
        File file = new File("C:\\Users\\Admin\\Downloads\\myNewFolder\\Text");
        System.out.println("File: " + file.getAbsolutePath());
    }
}
```
