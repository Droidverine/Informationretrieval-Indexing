# Informationretrieval-Indexing
This project demnostrates how a Information retrieval process works in a typical search engine.

The project mainly has 4 java file each of them is performing specific tasks:
1. Preprocess.java- It's the first step in infomration retrieval here we preprocess the documents by performing stopwords, punctuations        removal and tokenization of the query.The method which we used here for stemming is Porter Stemming which is not 100% accurate.
2. InvertedIndex.java- This program does the inverted indexing of the preprocessed documents
3. TDIDF.java- This program helps to find Term Document Inverted Frequency.
4. Cosinesim.java- This programs finds out the cosine similarty between two documents with the help of calculated TFIDF previously.
