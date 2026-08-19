# Movie Recommender System in Java

![Java](https://img.shields.io/badge/Java-course%20project-ED8B00?logo=openjdk&logoColor=white)
![Method](https://img.shields.io/badge/method-user--based%20collaborative%20filtering-2563EB)
![Scope](https://img.shields.io/badge/scope-educational-0F766E)

A user-based collaborative-filtering movie recommender developed for Duke University's [Java Programming: Build a Recommendation System](https://www.coursera.org/learn/java-programming-recommender) course on Coursera.

This repository contains my coursework implementation built on the course's starter structure. It demonstrates object-oriented design, ratings-data processing, similarity scoring, filtering, and HTML recommendation output; it is not presented as a production recommendation service.

<img width="1060" height="830" alt="HTML output from the Java movie recommender" src="https://github.com/user-attachments/assets/dc253bea-815e-4744-84ad-a6fe1a514a32">

## What the system does

Given a target user's movie ratings, the recommender:

1. Loads movie metadata and rater data from CSV files.
2. Measures similarity between the target user and other raters.
3. Selects raters with the strongest positive similarity.
4. Computes weighted recommendation scores.
5. Applies configurable eligibility and movie filters.
6. Sorts candidates and renders the result as an HTML table.

## Core capabilities

- In-memory movie and rater databases
- Dot-product user-similarity scoring
- Weighted-average recommendation scores
- Minimum-rater thresholds
- Composable movie filters
- Ranked HTML output
- Graceful handling when no eligible recommendations exist

## Design

| Component | Responsibility |
| --- | --- |
| `MovieDatabase` | Loads and exposes movie metadata |
| `RaterDatabase` | Stores ratings and retrieves raters |
| `FourthRatings` | Computes similarity and weighted recommendations |
| `Filter` implementations | Restrict candidates by movie attributes |
| Tester and runner classes | Exercise course milestones and generate output |

This separation keeps data access, recommendation logic, filtering, and presentation concerns distinct.

## Recommendation method

For a target user \(u\) and another rater \(v\), the project derives a similarity score from their overlapping ratings. Candidate movie scores are then aggregated from positively similar raters using a similarity-weighted average.

This is a learning implementation of user-based collaborative filtering. It does not include modern ranking models, online learning, cold-start handling, or production evaluation infrastructure.

## Running the project

The repository preserves the course project layout and does not currently include Maven or Gradle build metadata.

Use the course-supported Java/BlueJ environment and the required Duke course libraries and datasets:

1. Download or clone the repository.
2. Open the relevant project folder in BlueJ.
3. Add the course-provided libraries and rating datasets if they are not already available.
4. Compile the project.
5. Run the tester class for the course milestone you want to reproduce.
6. Open the generated HTML output in a browser.

A repository-level `.gitignore` keeps regenerated `.class` files and unrelated IDE build
directories out of version control while preserving the BlueJ project metadata used by the course.

A standalone CLI build will require first adding explicit dependency and build configuration.

## Example output

The generated table can contain:

- Recommendation rank
- Movie title
- Weighted recommendation score
- Additional movie metadata exposed by the selected filters

If no movie satisfies the configured rater threshold and filters, the program reports that no recommendations are available.

## Learning outcomes

This project strengthened my experience with:

- Object-oriented Java design
- Interfaces and composable filters
- Collections and CSV data processing
- Similarity-based recommendation algorithms
- Sorting and weighted aggregation
- Generating browser-readable output from Java

## Attribution and limitations

- Course: [Java Programming: Build a Recommendation System](https://www.coursera.org/learn/java-programming-recommender)
- Provider: Duke University via Coursera
- Scope: educational coursework based on course starter materials
- Current repository state: no standalone build metadata or automated CI suite

No repository license is currently included. Course materials and datasets may have separate terms; reuse permission should not be assumed.
