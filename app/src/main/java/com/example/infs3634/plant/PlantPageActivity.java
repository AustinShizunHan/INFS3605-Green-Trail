package com.example.infs3634.plant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.timeline.TimelineActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class PlantPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Plant> plants;
    private EditText searchBar;
    private Button sortButton;
    private boolean ascendingOrder = true;
    private ImageButton imageButton;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_page);

        // Use bottom navigation bar to switch between pages
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.search);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        launchHomeActivity();
                        // handle Home tab selection
                        return true;
                    case R.id.location:
                        launchMapActivity();
                        // handle location tab selection
                        return true;
                    case R.id.search:
                        //launchPlantPageActivity();
                        // handle search tab selection
                        return true;
                    case R.id.quiz:
                        launchQuizActivity();
                        // handle quiz tab selection
                        return true;
                    case R.id.scancode:
                        launchTimelineActivity();
                        // handle timeline tab selection
                        return true;
                }
                return false;
            }
        });

        //Press image button to open QR code page
        ImageButton imagebutton = findViewById(R.id.timeline);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the QRScanActivity
                Intent intent = new Intent(PlantPageActivity.this, TimelineActivity.class);
                // Start the QRScanActivity
                startActivity(intent);
            }
        });

        // Put plants info into the list
        plants = new ArrayList<>();
        plants.add(new Plant("Hill's Fig", R.drawable.abc, "G5 Blockhouse ", " Hill's Fig is a large, evergreen tree that can grow up to 25 meters tall. It has a broad, spreading canopy and dense foliage that provides shade and shelter for a variety of wildlife. The leaves are glossy and dark green, with a smooth texture and pointed tips. The tree produces small, round fruit that are edible but not usually eaten by humans.\n" +
                "\n" +
                "(location: G5 Blockhouse) "));
        plants.add(new Plant("Gymea Lilly", R.drawable.b, "Roundhouse", "The Gymea Lily can grow up to 4 meters tall and produces a tall, spear-like inflorescence that can reach up to 6 meters in height. The inflorescence is covered in hundreds of bright red flowers that attract birds and other wildlife. The leaves are strap-like and can grow up to 2 meters long, forming a large rosette at the base of the plant.\n" +
                "\n" +
                " (location: Roundhouse)"));
        plants.add(new Plant("Broad-leaved Paperbark", R.drawable.c, "SquareHouse", "The Broad-leaved Paperbark can grow up to 20 meters tall and has a distinctive, papery bark that peels away in strips. The leaves are long and narrow, with five distinct veins running parallel to the midrib. The tree produces clusters of small, white flowers that are highly attractive to bees and other pollinators.\n" +
                "\n" +
                "(location: SquareHouse) "));
        plants.add(new Plant("Crimson Bottlerush", R.drawable.d, "Pool Lawn", "The Crimson Bottlebrush can grow up to 5 meters tall and has striking, cylindrical flower spikes that are bright red in color. The leaves are narrow and lance-shaped, with a lemon-like fragrance when crushed. The tree produces small, woody fruits that contain numerous small seeds.\n" +
                "\n" +
                "(location: Pool Lawn) "));
        plants.add(new Plant("Heath Banksia", R.drawable.e, "Pool Lawn", "Banksia ericifolia grows as a large shrub up to 6 metres (20 feet) in height, though often smaller, around 1–2 metres (3.5–6.5 ft), in exposed places such as coastal or mountain heathlands. The grey-coloured bark is smooth and fairly thin with lenticels; however it can thicken significantly with age.\n" +  "\n" +
                "(location: Pool Lawn) "));
        plants.add(new Plant("Mountain Cedar Wattle", R.drawable.wz, "International House ", "The tree can grow to a height of around 20 m (66 ft) when mature, with exceptional specimens reaching over 30 m (98 ft). It has deeply fissured bark with a dark brown to black colour at the base of the tree with terete branchlets that are hairy when young. The dark green evergreen leaves typically have a length of 2.5 to 9 cm (0.98 to 3.54 in) with one prominent gland about halfway along. \n" +  "\n" +
                "(location: International House) "));
        plants.add(new Plant("Native Mint", R.drawable.g, " International House", "The Native Mint can grow up to 1 meter tall and has oval-shaped leaves with a strong minty fragrance. The flowers are small and white or purple in color, and are arranged in clusters at the end of the stems. The plant produces small, round seeds that are dispersed by wind or water.\n" +
                "\n" +
                "(location: International House) "));
        plants.add(new Plant("Tuckeroo", R.drawable.h, "Myers Studio", "Growing up to 10 metres (33 ft) with a stem diameter of 50 centimetres (20 in). The bark is smooth grey or brown with raised horizontal lines. The bases of the trees are usually flanged.\n" +
                "\n" +
                "Leaves are pinnate and alternate with six to ten leaflets. These are not toothed, and are egg-shaped to elliptic-oblong, and 7 to 10 centimetres (2.8 to 3.9 in) long. The tips are often notched or blunt.  \n" +
                "\n" +
                "\n" +
                "\n" +
                "(location: Myers Studio)"));
        plants.add(new Plant("Prickly Leaved Tea Tree", R.drawable.i, "Central Lecture Theater Block", "Leptospermum continentale is a slender, straggling shrub that typically grows to a height of 1–2 m (3 ft 3 in – 6 ft 7 in) or more. It has smooth bark that is shed in stringy strips. The leaves are narrow egg-shaped, 5–13 mm (0.20–0.51 in) long and 1–3.5 mm (0.039–0.138 in) wide with a sharp point on the end. "));
        plants.add(new Plant("Water Vine", R.drawable.j, "Central Lecture Theater Block", "Cissus hypoglauca is a large woody vine. The name water-vine comes from the fact that the woody sections of the vine may be cut into sections and the sap that drips from the sections may be drunk as water. The leaves are palmate, and are usually arranged in a group of five. Leaves elliptic or ovate in shape, slightly toothed or entire. Mid green above and a glaucous shade underneath, and measure 3 to 15 cm (1–6 in) long, 1.5 to 4 cm (0.6-1.6 in) wide. \n" +
                "\n" +
                ""));
        plants.add(new Plant("Rock Lily", R.drawable.lik, "Central Lecture Theater Block", "The Rock Lily can grow up to 1 meter tall and has large, showy flowers that are usually white or pale pink in color, with a yellow or orange center. The flowers are arranged in clusters at the end of the stems, and the plant produces long, thin leaves that are usually green in color.\n" +
                "\n" +
                "The Rock Lily is an important plant in many ecosystems, providing habitat for a variety of wildlife. "));
        plants.add(new Plant("Sandpaper Fig", R.drawable.xc, "Central Lecture Theater Block", "The sandpaper fig is a small tree which may reach the dimensions of 6–12 m (20–39 ft) tall by 3–5 m (9.8–16.4 ft) wide, although is generally smaller. The trunk is dark brown, and the ovate or elliptical leaves are 5–15 cm (2.0–5.9 in) long by 2–5 cm (0.79–1.97 in) wide and very scabrous (rough) like sandpaper on the upper side. The new growth is hairy. The succulent oval fruit is around 1.5 cm (0.59 in) long and covered in dense hairs"));
        plants.add(new Plant("Burrawang", R.drawable.m, "Sir John Clancy Auditorium", "The Burrawang can grow up to 10 meters tall and has a distinctive, palm-like appearance, with a trunk covered in rough, bark-like scales and a crown of long, feathery fronds. The plant produces large, cone-shaped fruits that contain highly toxic seeds.\n" +
                "\n" +
                "The Burrawang is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Plum Pine", R.drawable.n, "Chancellery North \n" +
                "\n" +
                "", "It is a medium to large evergreen tree growing to 30–36 m tall with a trunk up to 1.5 m diameter. The leaves are lanceolate, 5–15 cm long (to 25 cm long on vigorous young trees) and 6–18 mm broad. The seed cones are dark blue-purple, berry-like, with a fleshy base 2-2.5 cm diameter bearing a single oval or globose seed 1 cm in diameter."));
        plants.add(new Plant("Tussock Grass", R.drawable.o, "Michael Birt Garden \n", "Tussock Grass can grow up to 1.5 meters tall and has a distinctive tussock or clumping growth habit, with long, narrow leaves that are blue-green in color. The plant produces seed heads in late spring or early summer, which contain numerous small seeds.\n" +
                "\n" +
                "Tussock Grass is an important plant in many ecosystems, providing habitat and food for a variety of wildlife. "));
        plants.add(new Plant("Cabbage Tree Palm", R.drawable.p, "Sir John Clancy Auditorium", "It is crowned with dark, glossy green leaves on petioles 2 m long. It has leaves plaited like a fan; the cabbage of these is small but sweet. In summer it bears flower spikes with sprigs of cream-white flowers. The trees accumulate dead fronds or leaves, which when the plant is in cultivation are often removed by an arborist.\n" +
                "\n" +
                ""));
        plants.add(new Plant("Bolwarra", R.drawable.q, "Samuels \n", "Bolwarra can grow up to 10 meters tall and has dark green, glossy leaves that are oval or lance-shaped. The plant produces small, greenish-yellow flowers that are highly fragrant and followed by red or purple, edible fruit that is sweet and aromatic.\n" +
                "\n" +
                "Bolwarra is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Blue Flax Lily", R.drawable.r, "Library Walk", "Blue Flax Lily can grow up to 1 meter tall and has long, narrow leaves that are blue-green in color. The plant produces clusters of small, star-shaped flowers that are blue or purple in color, followed by small, blue or black berries that are edible but not widely consumed.\n" +
                "\n" +
                "Blue Flax Lily is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Old man banksia", R.drawable.s, "Library Walk  ", "Banksia serrata usually grows as a gnarled and misshapen tree up to 16 m (50 ft) tall, although in some coastal habitats it grows as a shrub of 1–3 m (3–10 ft), and on exposed coastal cliffs it has even been recorded as a prostrate shrub. As a tree it usually has a single, stout trunk with warty, knobbly grey bark up to 3 cm (1.2 in) thick. Trunks are often black from past bushfires, and ooze a red sap when injured. "));
        plants.add(new Plant("Matrush", R.drawable.t, "Electrical Engineering", "Matrush can grow up to 1.5 meters tall and has long, narrow leaves that are dark green and strap-like in shape. The plant produces small, yellowish-green flowers that are arranged in dense clusters, followed by small, brownish-black berries.\n" +
                "\n" +
                "Matrush is an important plant in many ecosystems, providing habitat and food for a variety of wildlife. "));
        plants.add(new Plant("Ribery", R.drawable.u, "John Niland Scientia", "Riberry can grow up to 15 meters tall and has dark green, glossy leaves that are oval or lance-shaped. The plant produces small, white or creamy-yellow flowers that are highly fragrant, followed by edible, bright red fruit that is sweet and tangy, with a texture similar to a cranberry.\n" +
                "\n" +
                "Riberry is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Grass Tree", R.drawable.v, "John Niland Scientia", "All are perennials and have a secondary thickening meristem in the stem. Many, but not all, species develop an above ground stem. The stem may take up to twenty years to emerge. Plants begin as a crown of rigid grass-like leaves, the caudex slowly growing beneath. The main stem or branches continue to develop beneath the crown, This is rough-surfaced, built from accumulated leaf-bases around the secondarily thickened trunk. \n" +
                "\n" +
                "\n" +
                "\n" +
                ""));
        plants.add(new Plant("Native Ginger", R.drawable.w, "Science Theatre \n", "Native Ginger is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. It is also highly valued for its ornamental, culinary, and medicinal uses. The fruit can be used in jams, chutneys, and sauces, and the leaves and roots have traditional medicinal uses in some Aboriginal cultures. Native Ginger is a popular plant in gardens and public spaces due to its attractive appearance, hardiness, and versatility. "));
        plants.add(new Plant("Flame Tree", R.drawable.x, "Science Theatre", "This species is a large deciduous tree which forms a pyramidal habit. It may reach 30 to 35 m (98 to 115 ft) in height in its natural habitat, but is usually shorter in cultivation. The trunk is smoothly cylindrical and green or grey-green in colour, often tapering unbranched to the very tip of the tree. Leaves have long petioles and measure up to 30 cm (12 in) x 25 cm (9.8 in), are glossy green, glabrous, simple, alternate, and highly variable in shape \n" +
                "\n" +
                ""));
        plants.add(new Plant("Port Jackson Fig", R.drawable.y, " Law Building", "A spreading, densely-shading tree when mature, F. rubiginosa may reach 30 m (100 ft) or more in height, although it rarely exceeds 10 m (30 ft) in the Sydney region. The trunk is buttressed and can reach 1.5 m (4 ft 11 in) in diameter. The bark is yellow-brown. It can also grow as on other plants as a hemiepiphyte, or 1–5 m (3–16 ft) high lithophyte. \n" +
                "\n" +
                "It closely resembles its relative, the Moreton Bay fig (F. macrophylla). Having similar ranges in the wild, they are often confused. The smaller leaves, shorter fruit stalks, and rusty colour of the undersides of the leaves of F. rubiginosa are the easiest distinguishing features. It is also confused with the small-leaved fig (F. obliqua), the syconia of which are smaller, measuring 4–12 mm long and 4–11 mm in diameter, compared with 7–17 mm long and 8–17 mm diameter for F. rubiginosa."));
        recyclerView = findViewById(R.id.plants_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(plants, this);
        recyclerView.setAdapter(adapter);

        searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

    }

    // 4 Different page launchActivity class
    public void launchHomeActivity() {
        Intent intent = new Intent(PlantPageActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
            Intent intent = new Intent(PlantPageActivity.this, QuizStartPage.class);
            startActivity(intent);
    }

    public void launchMapActivity() {
            Intent intent = new Intent(PlantPageActivity.this, Activity.class);
            startActivity(intent);
    }

    public void launchTimelineActivity() {
            Intent intent = new Intent(PlantPageActivity.this, TimelineActivity.class);
            startActivity(intent);
    }

}
