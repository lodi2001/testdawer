package com.example.android.testdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.android.testdrawer.fragment.FragmentHome;
import com.example.android.testdrawer.fragment.Fragmentcontact;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  mText = (TextView) findViewById(R.id.text2);
     //   mText.setText("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_area, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;
        if (id == R.id.Article) {
            mText = (TextView) findViewById(R.id.text2);
            mText.setText("ضمن موقع إلكتروني يُعرِّف بالأطبّاء المحليين، السعوديين والوافدين، ويُمكِّن المرضى من حجز مواعيد معهم في مستشفياتنا وعياداتنا الخاصّة، لفت نظري ارتفاع تكلفة كشفية الأطبّاء السعوديين، وهي تتدرّج من ٤٠٠، ٥٠٠، وصولاً إلى ٨٠٠ ريال، للكشفية الواحدة التي قد تستغرق أقلّ من ١٠ دقائق، وفي تخصّصات طبية عادية وليست صعبة أو نادرة، صدِّق أو لا تُصدِّق!.مقابل ذلك: وجدتُ أطبّاء وافدين بتكلفة كشفية أقلّ ومعقولة، وهي تتدرّج من ١٠٠، ٢٠٠، وصولاً إلى ٣٠٠ ريال، رغم أنّ الشهادات العلمية والخبرات العملية والزمالات والسير الذاتية للجميع، السعوديين والوافدين، تبدو متقاربة، إن لم تكن لدى الوافدين أفضل، كما أنّ معظم الأطبّاء السعوديين المُعلِنِين عن أنفسهم في الموقع هم من صغار السنّ، ومغمورين مهنياً، ولم أسمع بهم طيلة حياتي، فلماذا جعلوا تكلفة كشفهم مرتفعة هكذا؟ أرجو ألّا يُقال لي لأنّهم مواطنون، فالطبّ وحسب معلوماتي المتواضعة لا تُختزل جودته في الطبيب المواطن داخل وطنه، ورُبّ طبيب وافد خيرٌ من طبيبٍ مواطن، ليس عندنا فقط بل في كلّ بلد، ولا ينبغي أن يكون هناك تمييز في أسعار الكشفيات لصالح الأطبّاء السعوديين فقط لأنّهم مواطنون، وإلّا صار ذلك عنصرية في أسعار الكشفيات بلا وجه حقّ!.أنا مع تربّح الأطبّاء السعوديين من مهنتهم، وأتمنّى لهم الخير، في وظائفهم الصباحية وممارستهم للطبّ مساءً خارج أوقات الدوام، لكن أن يتحوّلوا لشهبندرات تُجّار باسم المُوَاطَنة، وأن يُصبح دخْل الواحد منهم أكبر من دخل وزير الصحّة نفسه عدّة مرّات، فقط من الكشفيات المُبالَغ في قيمتها، فهذا أمرٌ جدير بإعادة النظر، لا سيّما وأنّ معظم الأطبّاء السعوديين لا يتعاملون مع شركات التأمين، فلا يجد المرضى سوى الدفع لهم نقداً، وفُقْدان ميزة التأمين!.وعلى طريقة: انصر أخاك ظالماً أو مظلوماً، سأنصر الأطبّاء السعوديين بمطالبة وزارة الصحة ووزارة التجارة بوضع تسعيرة عادلة لكشفيتهم، بحيث لا تكون مرتفعة فيتضرّر المرْضى، ولا منخفضة فيتضرّرون هم، وهذا هو الانتصار الحقيقي والعادل، وإلّا أصبح أطبّاؤنا مثل لاعبي كرة القدم السعوديين المحترفين، فلوسهم كثيرة في أنديتهم، وعطاؤهم لمنتخب الوطن متواضع، ويا أمان جيوب المرضى!.");
            fragment = new Fragmentcontact();
            displayFragment(fragment);
            // Handle the camera action
        } else if (id == R.id.Consultant) {
            fragment = new FragmentHome();
            displayFragment(fragment);
        } else if (id == R.id.Cv) {

        } else if (id == R.id.Contact) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
