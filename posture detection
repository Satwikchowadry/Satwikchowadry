import cv2
import mediapipe as mp
import numpy as np

# Initialize MediaPipe Pose solution
mp_drawing = mp.solutions.drawing_utils
mp_drawing_styles = mp.solutions.drawing_styles
mp_pose = mp.solutions.pose

# Set up webcam capture
cap = cv2.VideoCapture(0)  # '0' is typically the default webcam

# Initialize the Pose model
with mp_pose.Pose(
        min_detection_confidence=0.5,
        min_tracking_confidence=0.5) as pose:
    while cap.isOpened():
        success, image = cap.read()
        if not success:
            print("Ignoring empty camera frame.")
            continue

        # Convert the BGR image to RGB
        image.flags.writeable = False
        image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        results = pose.process(image)

        # Draw the pose annotations on the image
        image.flags.writeable = True
        image = cv2.cvtColor(image, cv2.COLOR_RGB2BGR)
        if results.pose_landmarks:
            mp_drawing.draw_landmarks(
                image,
                results.pose_landmarks,
                mp_pose.POSE_CONNECTIONS,
                landmark_drawing_spec=mp_drawing_styles.get_default_pose_landmarks_style()
            )

        # Flip the image horizontally for a selfie-view display
        cv2.imshow('MediaPipe Pose', cv2.flip(image, 1))

        # Exit loop when the 'Esc' key is pressed
        if cv2.waitKey(5) & 0xFF == 27:
            break

# Release resources
cap.release()
cv2.destroyAllWindows()
