# Activitat 2 - Unit Testing & Mutation Testing

## Instruccions d'execució
- Per executar els tests: `mvn test`
- Per generar l'informe de JaCoCo: `mvn jacoco:report`
- Per executar Mutation Testing (PIT): `mvn pitest:mutationCoverage`

## Part C i D (A omplir a casa)
**JaCoCo:** Amb els tests de Calculator i DescompteService s'espera una cobertura gairebé del 100%. *(Nota: Afegeix la captura aquí quan ho executis a casa).*

**Anàlisi de Mutants (PIT):**
| Mutant | Estat | Per què? | Acció |
|---|---|---|---|
| (A omplir a casa) | | | |

## Respostes a les preguntes finals de reflexió
**1. Quina diferència has observat entre que una línia estigui coberta i que el comportament estigui ben provat?**
Que una línia estigui coberta només vol dir que l'execució ha passat per allà. Que estigui ben provada vol dir que hem validat (amb asserts) que el resultat és exactament l'esperat segons la lògica de negoci.

**2. Què t’ha aportat PIT que no t’havia mostrat l’informe de JaCoCo?**
PIT ha aportat informació sobre la qualitat i la robustesa dels meus tests. JaCoCo només mira línies executades, però PIT introdueix errors reals al codi; si el test no falla (Survived), vol dir que el test era feble.

**3. Quin valor límit ha estat més rellevant en DescompteService i per què?**
El valor 100 i el 99.99. Són crítics perquè és on es troba la frontera de la condició de l'if (`>= 100`). Un petit error com posar `>` en lloc de `>=` només es detecta provant just aquests valors frontera.

**4. En quin cas t’ha resultat útil el mock de StockRepository?**
Ha estat útil per poder provar la lògica de `ComandaService` (que comprova el nom del producte i truca al mètode teStock) sense necessitar una connexió a una base de dades real, aïllant la classe de les seves dependències.

**5. Quin test de la teva suite consideres que aporta més valor i per què?**
El test parametritzat de DescompteService, ja que de manera molt neta permet provar totes les combinacions de la taula en una sola funció, fent que el codi de proves sigui molt fàcil de mantenir.