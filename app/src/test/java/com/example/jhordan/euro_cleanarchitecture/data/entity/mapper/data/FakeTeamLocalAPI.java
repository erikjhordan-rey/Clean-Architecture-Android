/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jhordan.euro_cleanarchitecture.data.entity.mapper.data;

import com.example.jhordan.euro_cleanarchitecture.data.entity.ImageEntity;
import com.example.jhordan.euro_cleanarchitecture.data.entity.TeamEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FakeTeamLocalAPI {

  private static final String JSON_RESPONSE_TEAM = "{\n"
      + "    \"flag\": \"ALB\",\n"
      + "    \"name\": \"Albania\",\n"
      + "    \"images\": [\n"
      + "      {\n"
      + "        \"img_flag\": \"http://www.nationsonline.org/flags_big/albania_lgflag.gif\",\n"
      + "        \"img_profile\": \"http://img.uefa.com/imgml/2016/euro/teams/profile/S/ALB.jpg\",\n"
      + "        \"img_header\": \"http://img.uefa.com/imgml/2016/euro/teams/header/m/ALB.jpg\",\n"
      + "        \"img_detail\": \"http://img.uefa.com/MultimediaFiles/Photo/competitions/Goldenjubilee/01/59/01/50/1590150_w1.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"team_declaimer\": \"Albania jugará en la UEFA EURO 2016 su primera gran fase final de un torneo gracias al trabajo del seleccionador Gianni De Biasi, que ya dio esperanzas a los albaneses en la fase de clasificación para el Mundial de 2014.\",\n"
      + "    \"best_result\": \"nunca se había clasificado previamente\",\n"
      + "    \"coach\": \"Gianni De Biasi\",\n"
      + "    \"leading_scorer\": \"histórico, Erjon Bogdani (18); actual, Hamdi Salihi (11)\",\n"
      + "    \"nick_name\": \" Shqiponja (las águilas)\",\n"
      + "    \"stadium\": \"Elbasani Arena, Elbasan\",\n"
      + "    \"description_part_1\": \"Albania, una de las federaciones fundadoras de la UEFA, nunca se había clasificado para un gran torneo tras alcanzar la fase final de la UEFA EURO 2016, aunque sus resultados habían mejorado en los últimos años bajo las órdenes de experimentados seleccionadores como el alemán Hans-Peter Briegel o el holandés Arie Haan. Albania evitó la última plaza de su grupo en sus siete últimas fases de grupos. En la fase de clasificación para la Copa Mundial de la FIFA de 2014 estuvo cerca de alcanzar los play-offs bajo la dirección del italiano Gianni De Biasi, y ahora, ha logrado la clasificación tras terminar subcampeón en el Grupo I por detrás de Francia.\",\n"
      + "    \"matches_played\": \"J 93 G 18 E 22 P 53 GF 78 GC 159\",\n"
      + "    \"overall\": \"J 0 G 0 E 0 P 0 GF 0 GC 0\",\n"
      + "    \"final_tournament\": \"J 93 G 18 E 22 P 53 GF 78 GC 159\",\n"
      + "    \"description_part_2\": \"En su campaña de debut en el Campeonato de Europa de la UEFA, Albania logró una famosa victoria aislada en un grupo sin demasiados buenos resultados, un patrón que se ha repetido en numerosas fases de clasificación hasta la de la UEFA EURO 2016. Después de quedarse sin participar en el torneo de 1960, logró su primer triunfo en la competición en los octavos de final ante Dinamarca en su intento de lograr una plaza en la fase final de 1964. Un equipo liderado por el que quizá sea el jugador más destacado en la historia del país, Panajot Pano, ganó por 1-0 en Tirana, pero los daneses ya tenían encarrilada la eliminatoria con el 4-0 que habían logrado en el partido de ida.\",\n"
      + "    \"description_part_3\": \"Cuatro años después, Albania de nuevo demostró su calidad, a pesar de que ya estaba eliminada. Empató 0-0 ante la República Federal de Alemania y le impidió clasificarse para una fase final por única vez en su historia. Desde entonces, ha logrado éxitos de forma esporádica, como cuando venció por 3-0 a Turquía en la fase de clasificación para el torneo de 1972, o en su memorable triunfo por 3-1 sobre Rusia en 2003. Albania logró su mejor actuación en la fase de clasificación para la UEFA EURO 2008, donde sumó once puntos, pero aun así no logró el pase a la fase final. Cuatro años más tarde, ha finalizado segunda de grupo por detrás de Portugal para alcanzar su primera fase final.\"\n"
      + "  }";

  private static final String JSON_RESPONSE_TEAM_COLLECTION = "[\n"
      + "  {\n"
      + "    \"flag\": \"ALB\",\n"
      + "    \"name\": \"Albania\",\n"
      + "    \"images\": [\n"
      + "      {\n"
      + "        \"img_flag\": \"http://www.nationsonline.org/flags_big/albania_lgflag.gif\",\n"
      + "        \"img_profile\": \"http://img.uefa.com/imgml/2016/euro/teams/profile/S/ALB.jpg\",\n"
      + "        \"img_header\": \"http://img.uefa.com/imgml/2016/euro/teams/header/m/ALB.jpg\",\n"
      + "        \"img_detail\": \"http://img.uefa.com/MultimediaFiles/Photo/competitions/Goldenjubilee/01/59/01/50/1590150_w1.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"team_declaimer\": \"Albania jugará en la UEFA EURO 2016 su primera gran fase final de un torneo gracias al trabajo del seleccionador Gianni De Biasi, que ya dio esperanzas a los albaneses en la fase de clasificación para el Mundial de 2014.\",\n"
      + "    \"best_result\": \"nunca se había clasificado previamente\",\n"
      + "    \"coach\": \"Gianni De Biasi\",\n"
      + "    \"leading_scorer\": \"histórico, Erjon Bogdani (18); actual, Hamdi Salihi (11)\",\n"
      + "    \"nick_name\": \" Shqiponja (las águilas)\",\n"
      + "    \"stadium\": \"Elbasani Arena, Elbasan\",\n"
      + "    \"description_part_1\": \"Albania, una de las federaciones fundadoras de la UEFA, nunca se había clasificado para un gran torneo tras alcanzar la fase final de la UEFA EURO 2016, aunque sus resultados habían mejorado en los últimos años bajo las órdenes de experimentados seleccionadores como el alemán Hans-Peter Briegel o el holandés Arie Haan. Albania evitó la última plaza de su grupo en sus siete últimas fases de grupos. En la fase de clasificación para la Copa Mundial de la FIFA de 2014 estuvo cerca de alcanzar los play-offs bajo la dirección del italiano Gianni De Biasi, y ahora, ha logrado la clasificación tras terminar subcampeón en el Grupo I por detrás de Francia.\",\n"
      + "    \"matches_played\": \"J 93 G 18 E 22 P 53 GF 78 GC 159\",\n"
      + "    \"overall\": \"J 0 G 0 E 0 P 0 GF 0 GC 0\",\n"
      + "    \"final_tournament\": \"J 93 G 18 E 22 P 53 GF 78 GC 159\",\n"
      + "    \"description_part_2\": \"En su campaña de debut en el Campeonato de Europa de la UEFA, Albania logró una famosa victoria aislada en un grupo sin demasiados buenos resultados, un patrón que se ha repetido en numerosas fases de clasificación hasta la de la UEFA EURO 2016. Después de quedarse sin participar en el torneo de 1960, logró su primer triunfo en la competición en los octavos de final ante Dinamarca en su intento de lograr una plaza en la fase final de 1964. Un equipo liderado por el que quizá sea el jugador más destacado en la historia del país, Panajot Pano, ganó por 1-0 en Tirana, pero los daneses ya tenían encarrilada la eliminatoria con el 4-0 que habían logrado en el partido de ida.\",\n"
      + "    \"description_part_3\": \"Cuatro años después, Albania de nuevo demostró su calidad, a pesar de que ya estaba eliminada. Empató 0-0 ante la República Federal de Alemania y le impidió clasificarse para una fase final por única vez en su historia. Desde entonces, ha logrado éxitos de forma esporádica, como cuando venció por 3-0 a Turquía en la fase de clasificación para el torneo de 1972, o en su memorable triunfo por 3-1 sobre Rusia en 2003. Albania logró su mejor actuación en la fase de clasificación para la UEFA EURO 2008, donde sumó once puntos, pero aun así no logró el pase a la fase final. Cuatro años más tarde, ha finalizado segunda de grupo por detrás de Portugal para alcanzar su primera fase final.\"\n"
      + "  },\n"
      + "  {\n"
      + "    \"flag\": \"AUT\",\n"
      + "    \"name\": \"Austria\",\n"
      + "    \"images\": [\n"
      + "      {\n"
      + "        \"img_flag\": \"http://www.nationsonline.org/flags_big/Austria_lgflag.gif\",\n"
      + "        \"img_profile\": \"http://img.uefa.com/imgml/2016/euro/teams/profile/S/AUT.jpg\",\n"
      + "        \"img_header\": \"http://img.uefa.com/imgml/2016/euro/teams/header/m/AUT.jpg\",\n"
      + "        \"img_detail\": \"http://img.uefa.com/MultimediaFiles/Photo/competitions/Comp_Matches/71/52/30/715230_w1.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"team_declaimer\": \"Los grandes días del fútbol austriaco quedaron atrás, pero hay señales de aliento para los co-anfitriones de la UEFA EURO 2008 con el suizo Marcel Koller al mando.\",\n"
      + "    \"best_result\": \"fase de grupos de 2008\",\n"
      + "    \"coach\": \"Marcel Koller\",\n"
      + "    \"leading_scorer\": \"histórico, Toni Polster (44); actual, Marc Janko (25)\",\n"
      + "    \"nick_name\": \"ninguno\",\n"
      + "    \"stadium\": \"Ernst-Happel-Stadion, Viena\",\n"
      + "    \"description_part_1\": \"Los días de gloria del fútbol austríaco son cosa del pasado, con la tercera plaza en la Copa Mundial de la FIFA de 1954 como su mayor logro. En total, Austria ha participado en siete Mundiales, la última vez en Francia '98, pero sólo había competido en un Campeonato de Europa de la UEFA, cuando fue co-anfitriona en 2008 y se quedó fuera de las rondas eliminatorias tras caer ante Alemania. Su rival del otro lado de la frontera volvió a ver su bestia negra en la fase de clasificación de la UEFA EURO 2012 y de la Copa Mundial de la FIFA de 2014, aunque parece que hay signos de recuperación bajo el mando del técnico suizo Marcel Koller después de lograr el pase a Francia tras nueve victorias y un empate en diez encuentros de clasificación.  \",\n"
      + "    \"matches_played\": \"J 103 G 45 E 18 P 40 GF 185 GC 150\",\n"
      + "    \"overall\": \"J 3 G 0 E 1 P 2 GF 1 GC 3\",\n"
      + "    \"final_tournament\": \"J 100 G 45 E 17 P 38 GF 184 GC 147\",\n"
      + "    \"description_part_2\": \"La UEFA EURO 2008 sigue siendo la única participación de Austria en una fase final de una Eurocopa y no duró mucho en un torneo que acogió junto a Suiza, ya que los de Josef Hickersberger pagaron la falta de experiencia. Perdieron el primer partido ante Croacia, y tras empatar en el segundo ante Polonia, no llegaron a las rondas eliminatorias al perder el tercer encuentro por 1-0 ante Alemania.\",\n"
      + "    \"description_part_3\": \"Austria nunca ha podido repetir sus impresionantes clasificaciones para la Copa Mundial de la FIFA en los Campeonatos de Europa de la UEFA, aunque en la campaña de 2012 estuvo cerca, pero después de un brillante inicio terminó cuarta en la fase de clasificación. Se quedó a un punto de la clasificación directa para la fase final de 1980 y debido a dos derrotas en Reino Unido, 1-0 en Gales (1976) y 5-3 en Irlanda del Norte (1996), también se quedó fuera de otros dos campeonatos.\"\n"
      + "  },"
      + "  {\n"
      + "    \"flag\": \"BEL\",\n"
      + "    \"name\": \"Bélgica\",\n"
      + "    \"images\": [\n"
      + "      {\n"
      + "        \"img_flag\": \"http://www.nationsonline.org/flags_big/Belgium_lgflag.gif\",\n"
      + "        \"img_profile\": \"http://img.uefa.com/imgml/2016/euro/teams/profile/S/BEL.jpg\",\n"
      + "        \"img_header\": \"http://img.uefa.com/imgml/2016/euro/teams/header/m/BEL.jpg\",\n"
      + "        \"img_detail\": \"http://img.uefa.com/MultimediaFiles/Photo/competitions/Comp_Matches/01/72/52/31/1725231_w1.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"team_declaimer\": \"Vea los cinco goles de Bélgica durante la fase de clasificación y eche un vistazo a su trayectoria en la EURO, a la cual regresa el combinado belga ocupando el primer puesto del ránking FIFA.\",\n"
      + "    \"best_result\": \"finalista (1980)\",\n"
      + "    \"coach\": \"Marc Wilmots\",\n"
      + "    \"leading_scorer\": \"histórico, Bernard Voorhoff, Paul Van Himst (30); actual, Marouane Fellaini (15)\",\n"
      + "    \"nick_name\": \"Rode Duivels/Diables Rouges (los diablos rojos)\",\n"
      + "    \"stadium\": \"Stade Roi Baudaouin, Bruselas\",\n"
      + "    \"description_part_1\": \"Bélgica acabó con 12 años de ausencia en un gran torneo con una impresionante clasificación para la Copa Mundial de la FIFA de 2014, donde llegó a cuartos de final. Los buenos tiempos vuelven del lado de Marc Wilmots, que lideró al combinado hacia la UEFA EURO 2016. En Francia espera mejorar o igualar anteriores éxitos, como el subcampeonato de la EURO '80 y la cuarta plaza de la Copa Mundial de la FIFA de 1986.\",\n"
      + "    \"matches_played\": \"J 116 G 53 E 28 P 35 GF 183 GC 132\",\n"
      + "    \"overall\": \"J 12 G 4 E 2 P 6 GF 13 GC 20\",\n"
      + "    \"final_tournament\": \"J 104 G 49 E 26 P 29 GF 170 GC 112\",\n"
      + "    \"description_part_2\": \"Bélgica ha vuelto al grupo de élite en Europa y ha puesto fin a tres décadas desde su última clasificación para un Campeonato de Europa de la UEFA en el cual era un inquilino habitual de las fases finales durante la década de los 70 y principios de los 80. Bélgica acabó tercera en casa en 1972 y ocho años después subió un peldaño más en su búsqueda de levantar el trofeo, pero cayó en Roma por 2-1 ante la República Federal de Alemania.\",\n"
      + "    \"description_part_3\": \"Desde entonces los 'diablos rojos' llegaron a dos fases de grupos más, en 1984 y 2000, cuando fue co-anfitriona, aunque en ambas ocasiones se quedó fuera a las primeras de cambio. La fase de clasificación a la UEFA EURO 2012 llegó muy pronto para la nueva generación belga, y el equipo de Georges Leekens nunca se recuperó de sus dos primeras derrotas en el Grupo A y acabó en la tercera plaza, dos puntos por detrás de Turquía en la lucha por el play-off. Ahora, sin embargo, tienen cuatro años más de experiencia.\"\n"
      + "\n"
      + "  }]";

  public static String getJsonResponseTeam() {
    return JSON_RESPONSE_TEAM;
  }

  public static String getJsonResponseTeamCollection() {
    return JSON_RESPONSE_TEAM_COLLECTION;
  }

  public static List<ImageEntity> getJsonResponseImages() {
    List<ImageEntity> imageEntities = new ArrayList<>();
    ImageEntity imageEntity = new ImageEntity();
    imageEntity.setImageFlag("http://www.nationsonline.org/flags_big/Belgium_lgflag.gif");
    imageEntity.setImageProfile("http://img.uefa.com/imgml/2016/euro/teams/profile/S/BEL.jpg");
    imageEntity.setImageDetail(
        "http://img.uefa.com/MultimediaFiles/Photo/competitions/Comp_Matches/01/72/52/31/1725231_w1.jpg");
    imageEntity.setImageHeader("http://img.uefa.com/imgml/2016/euro/teams/header/m/BEL.jpg");
    imageEntities.add(imageEntity);
    return imageEntities;
  }

  private final static String FAKE_TEAM_FLAG = "ALB";
  private final static String FAKE_TEAM_NAME = "Albania";

  public static TeamEntity getFakeTeamEntity() {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setTeamFlag(FAKE_TEAM_FLAG);
    teamEntity.setTeamName(FAKE_TEAM_NAME);
    teamEntity.setImages(FakeTeamLocalAPI.getJsonResponseImages());
    //you can try set each attribute is possible
    return teamEntity;
  }
}
