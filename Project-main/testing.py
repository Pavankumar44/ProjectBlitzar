import re
import torch
from youtube_transcript_api import YouTubeTranscriptApi
from transformers import BartForConditionalGeneration, BartTokenizer

# # Step 1: Extract Transcript from YouTube Video
# def get_transcript_from_video(video_id):
#     transcript = YouTubeTranscriptApi.get_transcript(video_id)
#     transcript_text = ' '.join([entry['text'] for entry in transcript])
#     return transcript_text

# # Step 2: Generate Summary using BART model
# def generate_summary(transcript_text):
#     model_name = "facebook/bart-large-cnn"
#     model = BartForConditionalGeneration.from_pretrained(model_name)
#     tokenizer = BartTokenizer.from_pretrained(model_name)

#     input_ids = tokenizer(transcript_text, return_tensors="pt").input_ids
#     summary_ids = model.generate(input_ids, num_beams=4, max_length=50, early_stopping=True)
#     summary = tokenizer.decode(summary_ids[0], skip_special_tokens=True)
    
#     return summary

# Step 1: Extract Transcript from YouTube Video
def get_transcript_from_video(video_id):
    transcript = YouTubeTranscriptApi.get_transcript(video_id)
    transcript_text = ' '.join([entry['text'] for entry in transcript])
    return transcript_text

# Step 2: Generate Summary using BART model
def generate_summary(transcript_text):
    model_name = "facebook/bart-large-cnn"
    model = BartForConditionalGeneration.from_pretrained(model_name)
    tokenizer = BartTokenizer.from_pretrained(model_name)

    max_chunk_length = 1024  # Set the maximum chunk length

    # Split the transcript into chunks
    chunks = [transcript_text[i:i+max_chunk_length] for i in range(0, len(transcript_text), max_chunk_length)]

    summaries = []

    for chunk in chunks:
        input_ids = tokenizer(chunk, return_tensors="pt").input_ids
        summary_ids = model.generate(input_ids, num_beams=4, max_length=50, early_stopping=True)
        summary = tokenizer.decode(summary_ids[0], skip_special_tokens=True)
        summaries.append(summary)

    return ' '.join(summaries)

# Step 3: Extract Video ID from YouTube URL
def get_video_id_from_url(url):
    video_id = None

    # Extract video ID from different URL formats
    patterns = [
        r"(?:https?:\/\/)?(?:www\.)?(?:youtube\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})",
        r"^([a-zA-Z0-9_-]{11})$"
    ]

    for pattern in patterns:
        match = re.search(pattern, url)
        if match:
            video_id = match.group(1)
            break

    return video_id

# Step 4: Provide the YouTube video URL
video_url = 'https://youtu.be/rLXcLBfDwvE?si=7yTUONESa5cjgNQW'  # Replace with your own video URL
video_id = get_video_id_from_url(video_url)

if video_id:
    # Step 5: Get transcript and generate summary
    transcript_text = get_transcript_from_video(video_id)
    summary = generate_summary(transcript_text)

    # Step 6: Print the summary
    print("Summary:", summary)
else:
    print("Invalid YouTube URL")
