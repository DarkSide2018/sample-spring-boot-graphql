import os
import sys
from natasha import (
    Segmenter,
    NewsEmbedding,
    NewsMorphTagger,
    NewsNERTagger,
    PER,
    Doc
)


def natasha_recognizer(text):
    segmenter = Segmenter()
    emb = NewsEmbedding()
    morph_tagger = NewsMorphTagger(emb)
    ner_tagger = NewsNERTagger(emb)
    doc = Doc(text)
    doc.segment(segmenter)
    doc.tag_morph(morph_tagger)
    doc.tag_ner(ner_tagger)
    for span in doc.spans:
        if span.type == PER:
            return span.text


if __name__ == "__main__":
    x = natasha_recognizer(sys.argv[1])
